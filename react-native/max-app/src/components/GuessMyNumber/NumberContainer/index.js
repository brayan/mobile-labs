import { Dimensions, StyleSheet, Text, View } from "react-native";
import { GuessMyNumberColors } from "../../../contants/colors";

export default function NumberContainer({ children }) {
  return (
    <View style={styles.container}>
      <Text style={styles.numberText}>{children}</Text>
    </View>
  );
}

// screen is the size including the status bar
// window is the size excluding the status bar
const deviceWidth = Dimensions.get('window').width;

const styles = StyleSheet.create({
  container: {
    padding: deviceWidth < 380 ? 12 : 24,
    margin: deviceWidth < 380 ? 12 : 24,
    borderWidth: 4,
    borderRadius: 8,
    borderColor: GuessMyNumberColors.accent500,
    alignItems: "center",
    justifyContent: "center",
  },
  numberText: {
    fontFamily: 'open-sans-bold',
    color: GuessMyNumberColors.accent500,
    fontSize: 36,
  },
});
