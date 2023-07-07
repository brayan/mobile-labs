import { Dimensions, StyleSheet } from "react-native";

const width = Dimensions.get('screen').width;

const styles = StyleSheet.create({
    imageTopCover: {
        height: 578 / 768 * width,
        width: "100%",
    },
    textBasketScreenTitle: {
        color: "white",
        fontSize: 16,
        fontWeight: "bold",
        lineHeight: 26,
        padding: 16,
        position: "absolute", // relative is like LinearLayout
        textAlign: "center",
        width: "100%",
    },
});

export default styles;