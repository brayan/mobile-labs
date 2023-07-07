import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    imageFarmLogo: {
        height: 32,
        width: 32,
    },
    textFarmName: {
        color: "#919191",
        fontSize: 18,
        fontWeight: "bold",
        lineHeight: 26,
        paddingStart: 16,
    },
    textDescription: {
        color: "#919191",
        fontSize: 16,
        lineHeight: 26,
    },
    textPrice: {
        color: "#00FF99",
        fontSize: 26,
        fontWeight: "bold",
        lineHeight: 42,
        marginTop: 8,
    },
    textProductName: {
        color: "#FFFFFF",
        fontSize: 26,
        fontWeight: "bold",
        lineHeight: 42,
        marginBottom: 16,
    },
    viewBasketDescription: {
        paddingVertical: 8,
        paddingHorizontal: 16,
    },
    viewFarmNameAndImage: {
        flexDirection: "row",
        marginBottom: 8,
    },
});

export default styles;
