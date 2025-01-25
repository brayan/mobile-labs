import { StyleSheet } from "react-native";
import { spacing } from "../../../../design-system";

export const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
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
});
