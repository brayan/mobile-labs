import { StyleSheet, Text } from "react-native";
import { GuessMyNumberColors } from "../../../contants/colors";

export default function Title({ children }) {
    return (
        <Text style={styles.title}>{children}</Text>
    );
}

const styles = StyleSheet.create({
    title: {
        fontFamily: 'open-sans-bold',
        fontSize: 18,
        color: GuessMyNumberColors.white,
        textAlign: "center",
        borderWidth: 2,
        borderColor: GuessMyNumberColors.white,
        padding: 8,
    }
});