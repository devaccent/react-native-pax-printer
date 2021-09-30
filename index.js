import {NativeModules} from "react-native";
const {PaxPrinter} = NativeModules;

export const FULL_CUT = 0;
export const PARTIAL_CUT = 1;
const FontSizes = {XXS: 'XXS', XS: 'XS', SM: 'SM', MD: 'MD', LG: 'LG', XL: 'XL'}
const Alignments = {LEFT: 'LEFT', CENTER: 'CENTER', RIGHT: 'RIGHT'}
const TextStyles = {NORMAL: 'NORMAL', BOLD: 'BOLD', ITALIC: 'ITALIC', UNDERLINE: 'UNDERLINE'}

const getSafeCutMode = (cutMode) => cutMode === undefined ? FULL_CUT : cutMode;

export function printString(text, cutMode) {
  PaxPrinter.printLine(text, getSafeCutMode(cutMode));
}

export function printReceiptPage(receiptConfig){
  const json = JSON.stringify(receiptConfig);
  PaxPrinter.printReceiptPage(json);
}

export const ReceiptLineOptions = {
  FONT_SIZES: FontSizes,
  ALIGNMENTS: Alignments,
  TEXT_STYLES: TextStyles,
}

export default PaxPrinter;
