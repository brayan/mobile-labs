import { StyleSheet } from "react-native";
import { spacing } from "../../../../design-system";
import { MealsColors } from "../../../../constants/colors";

export const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  detailsContainer: {
    flexDirection: "row",
    alignItems: "center",
    padding: spacing.small,
    justifyContent: "center",
  },
  detailsText: {
    marginHorizontal: spacing.xSmall,
    fontSize: 12,
  },
  image: {
    width: '100%',
    height: 350,
  },
  title: {
    fontWeight: 'bold',
    fontSize: 24,
    margin: 8,
    textAlign: 'center',
    color: MealsColors.white,
  },
  detailText: {
    color: MealsColors.white,
  },
});
