import {NativeModules} from "react-native";
const {PaxPrinter} = NativeModules;

export const FULL_CUT = 0;
export const PARTIAL_CUT = 1;
const FontSizes = {XXS: 'XXS', XS: 'XS', SM: 'SM', MD: 'MD', LG: 'LG', XL: 'XL'}
const Alignments = {LEFT: 'LEFT', CENTER: 'CENTER', RIGHT: 'RIGHT'}
const TextStyles = {NORMAL: 'NORMAL', BOLD: 'BOLD', ITALIC: 'ITALIC', UNDERLINE: 'UNDERLINE'}

const getSafeCutMode = (cutMode) => cutMode === undefined ? FULL_CUT : cutMode;

export function printString(text, cutMode) {
  PaxPrinter.initPrinter();
  PaxPrinter.setGrayLevel(3);
  PaxPrinter.addTextLine(text);
  PaxPrinter.start();
}

export function printPage(receiptConfig){
  const json = JSON.stringify(receiptConfig);

  PaxPrinter.initPrinter();
  PaxPrinter.setGrayLevel(3);
  PaxPrinter.addPage(json);
  PaxPrinter.start();
}

export function savePageAsImage(receiptConfig){
  const json = JSON.stringify(receiptConfig);
  PaxPrinter.savePageAsImage(json);
}

export const PageLineOptions = {
  FONT_SIZES: FontSizes,
  ALIGNMENTS: Alignments,
  TEXT_STYLES: TextStyles,
}

export default PaxPrinter;
