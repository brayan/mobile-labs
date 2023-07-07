const { StyleSheet } = require("react-native");

const styles = StyleSheet.create({
    imageBasketItem: {
        height: 46,
        width: 46,
    },
    textBasketItemName: {
        color: "#FFFFFF",
        fontSize: 16,
        lineHeight: 26,
        marginHorizontal: 16
    },
    viewBasketItem: {
        alignItems: "center",
        borderBottomWidth: 1,
        borderBottomColor: "#ECECEC",
        flexDirection: "row",
        paddingVertical: 16,
        marginHorizontal: 16,
    },
})

export default styles;