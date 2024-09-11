import { Dimensions, StyleSheet, View } from "react-native";
import { GuessMyNumberColors } from "../../../contants/colors";

export default function Card({ children }) {
  return <View style={styles.container}>{children}</View>;
}

const deviceWidth = Dimensions.get("window").width;

const styles = StyleSheet.create({
  container: {
    marginTop: deviceWidth < 380 ? 18 : 36,
    marginHorizontal: 24,
    padding: 16,
    backgroundColor: GuessMyNumberColors.primary800,
    borderRadius: 8,
    elevation: 8,
    shadowColor: 'black',
    shadowOffset: { width: 0, height: 2 },
    justifyContent: 'center',
    alignItems: 'center',
  }
});
