import { Platform, StyleSheet } from "react-native";
import { borderRadius, spacing } from "../../../../design-system";

export const styles = StyleSheet.create({
  container: {
    margin: spacing.medium,
    borderRadius: borderRadius.medium,
    backgroundColor: "#FFF",
    elevation: 4,
    shadowColor: '#000',
    shadowOpacity: 0.35,
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowRadius: 8,
    overflow: Platform.select({ android: 'hidden', ios: 'visible' })
  },
  pressableContainer: {
    borderRadius: 9,
    overflow: "hidden"
  },
  buttonPressed: {
    opacity: 0.5,
  },
  image: {
    width: '100%',
    height: 200,
  },
  title: {
    fontWeight: "bold",
    textAlign: "center",
    fontSize: 18,
    margin: spacing.small,
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
