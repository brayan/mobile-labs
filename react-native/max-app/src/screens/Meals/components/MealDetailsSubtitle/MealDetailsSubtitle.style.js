import { StyleSheet } from "react-native";
import { MealsColors } from "../../../../constants/colors";

export const styles = StyleSheet.create({
  subtitle: {
    color: MealsColors.primary400,
    fontSize: 18,
    fontWeight: 'bold',
    marginHorizontal: 24,
    marginVertical: 4,
    padding: 6,
    textAlign: 'center',
    borderBottomColor: MealsColors.primary400,
    borderBottomWidth: 2,
  }
});
