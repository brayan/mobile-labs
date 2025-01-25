import { StyleSheet } from "react-native";
import { spacing } from "../../../../design-system";

export const styles = StyleSheet.create({
  container: {
    flexDirection: "row",
    alignItems: "center",
    padding: spacing.small,
    justifyContent: "center",
  },
  text: {
    marginHorizontal: spacing.xSmall,
    fontSize: 12,
  },
});
