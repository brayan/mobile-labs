import { StyleSheet, Text } from "react-native";
import { GuessMyNumberColors } from "../../../contants/colors";

export default function InstructionText({ children, style }) {
  return <Text style={[styles.text, style]}>{children}</Text>
}

const styles = StyleSheet.create({
  text: {
    fontFamily: 'open-sans',
    color: GuessMyNumberColors.accent500,
    fontSize: 24,
  }
});
