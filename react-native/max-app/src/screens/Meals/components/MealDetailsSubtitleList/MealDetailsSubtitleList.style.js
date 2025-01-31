import { StyleSheet } from "react-native";
import { MealsColors } from "../../../../constants/colors";

export const styles = StyleSheet.create({
  container: {
    borderRadius: 6,
    paddingHorizontal: 8,
    paddingVertical: 4,
    marginVertical: 4,
    marginHorizontal: 22,
    backgroundColor: MealsColors.primary400,
  },
  listItem: {
    color: MealsColors.primary600,
    textAlign: 'center'
  }
});
