import {NativeModules} from "react-native";
const {PaxPrinter} = NativeModules;

export const FULL_CUT = 0;
export const PARTIAL_CUT = 1;

const getSafeCutMode = (cutMode) => cutMode === undefined ? FULL_CUT : cutMode;

export function printStrings(strings, cutMode){
  const promise = PaxPrinter.initPrinter()
    .then(() => PaxPrinter.setGrayLevel(3))

  strings.forEach(string => {
    promise.then(() => PaxPrinter.addSimpleLine(string))
  });

  promise.then(() => PaxPrinter.printLines())
    .then(() => this.cutPaper(cutMode))

  return promise;
}

export function printString(text, cutMode) {
  return PaxPrinter.printOneLine(text, getSafeCutMode(cutMode));
}

export default PaxPrinter;
