declare var PaxPrinter: {
  initPrinter: () => void,
  setGrayLevel: (grayLevel: number) => void,

  addTextLine: (text: string) => void,
  addPage: (pageJson: string, saveAsImage: boolean) => void;

  start: () => void,
  cutPaper: (cutMode?: number) => void,
};

type FontSize = {XXS: string, XS: string, SM: string, MD: string, LG: string, XL: string}
type Alignment = {LEFT: string, CENTER: string, RIGHT: string}
type TextStyle = {NORMAL: string, BOLD: string, ITALIC: string, UNDERLINE: string}

export type PageLineUnit = {
  text: string;
  fontSize: FontSize;
  textStyle: TextStyle,
  align: Alignment
}

export type PageLine = {
  units: PageLineUnit[];
}

export type PageConfig = {
  lines: PageLine[];
}

export declare const FULL_CUT: number;
export declare const PARTIAL_CUT: number;
export declare const PageLineOptions: {
  FONT_SIZES: FontSize,
  ALIGNMENTS: Alignment,
  TEXT_STYLES: TextStyle,
}

export declare function printString(text: string, cutMode?: number): void;
export declare function printPage(pageConfig: PageConfig): void;

export default PaxPrinter;
