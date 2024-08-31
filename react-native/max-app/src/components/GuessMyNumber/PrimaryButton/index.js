import { Pressable, StyleSheet, Text, View } from "react-native";
import { GuessMyNumberColors } from "../../../contants/colors";

export default function PrimaryButton(props) {
    return (
        <View style={styles.buttonOuterContainer}>
            <Pressable
                style={({ pressed }) => pressed ? [styles.buttonInnerContainer, styles.pressed] : styles.buttonInnerContainer}
                onPress={props.onPress}
                android_ripple={{ color: GuessMyNumberColors.primary600 }}
            >
                <Text style={styles.buttonText}>{props.children}</Text>
            </Pressable>
        </View >
    );
}

const styles = StyleSheet.create({
    buttonOuterContainer: {
        borderRadius: 28,
        margin: 4,
        overflow: "hidden",
    },
    buttonInnerContainer: {
        backgroundColor: GuessMyNumberColors.primary500,
        paddingVertical: 8,
        paddingHorizontal: 16,
        elevation: 2,
    },
    buttonText: {
        color: '#FFF',
        textAlign: 'center',
    },
    pressed: {
        opacity: 0.75
    },
});
