declare var PaxPrinter: {
  initPrinter: () => void,
  setGrayLevel: (grayLevel: number) => void,
  addLine: (text: string) => void,
  start: () => void,
  cutPaper: (cutMode?: number) => void,

  printLine: (text: string, cutMode?: number) => void;
  printReceiptPage: (pageJson: string) => void;
};

type FontSize = {XXS: string, XS: string, SM: string, MD: string, LG: string, XL: string}
type Alignment = {LEFT: string, CENTER: string, RIGHT: string}
type TextStyle = {NORMAL: string, BOLD: string, ITALIC: string, UNDERLINE: string}

export type ReceiptPageLineUnit = {
  text: string;
  fontSize: FontSize;
  textStyle: TextStyle,
  align: Alignment
}

export type ReceiptPageLine = {
  units: ReceiptPageLineUnit[];
}

export type ReceiptPageConfig = {
  lines: ReceiptPageLine[];
}

export declare const FULL_CUT: number;
export declare const PARTIAL_CUT: number;
export declare const ReceiptLineOptions: {
  FONT_SIZES: FontSize,
  ALIGNMENTS: Alignment,
  TEXT_STYLES: TextStyle,
}

export declare function printString(text: string, cutMode?: number): void;
export declare function printReceiptPage(pageConfig: ReceiptPageConfig): void;

export default PaxPrinter;
