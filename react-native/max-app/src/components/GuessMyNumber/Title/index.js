import { Platform, StyleSheet, Text } from "react-native";
import { GuessMyNumberColors } from "../../../contants/colors";

export default function Title({ children }) {
  return (
    <Text style={styles.title}>{children}</Text>
  );
}

const styles = StyleSheet.create({
  title: {
    fontFamily: 'open-sans-bold',
    fontSize: 18,
    color: GuessMyNumberColors.white,
    textAlign: "center",
    // borderWidth: Platform.OS === 'android' ? 2 : 0,
    borderWidth: Platform.select({ ios: 0, android: 2 }),
    borderColor: GuessMyNumberColors.white,
    padding: 8,
    maxHeight: '80%',
  }
});