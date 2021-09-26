declare var PaxPrinter: {
  initPrinter: () => Promise<void>,
  setGrayLevel: (grayLevel: number) => Promise<void>,
  addSimpleLine: (text: string) => Promise<void>,
  printLines: () => Promise<void>,
  cutPaper: (cutMode?: number) => Promise<void>,

  printOneLine: (text: string, cutMode?: number) => Promise<void>;
};

export declare const FULL_CUT: number;
export declare const PARTIAL_CUT: number;
export declare function printStrings(strings: string[], cutMode?: number): Promise<void>;
export declare function printString(text: string, cutMode?: number): Promise<void>;

export default PaxPrinter;
