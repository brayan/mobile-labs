import { Platform, StyleSheet } from "react-native";

export const styles = StyleSheet.create({
  container: {
    flex: 1,
    height: 150,
    borderRadius: 8,
    elevation: 4,
    margin: 16,
    shadowColor: '#000',
    shadowOpacity: 0.25,
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowRadius: 8,
    overflow: Platform.select({ android: 'hidden', ios: 'visible' })
  },
  button: {
    flex: 1,
  },
  buttonPressed: {
    opacity: 0.5
  },
  content: {
    flex: 1,
    padding: 16,
    borderRadius: 8,
    justifyContent: 'center',
    alignItems: "center",
  },
  title: {
    fontWeight: "bold",
    fontSize: 18,
  }
});
