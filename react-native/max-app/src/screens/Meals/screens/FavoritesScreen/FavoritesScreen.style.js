import { StyleSheet } from "react-native";
import { MealsColors } from "../../../../constants/colors";

export const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  text: {
    fontSize: 18,
    fontWeight: 'bold',
    color: MealsColors.white,
  }
});
