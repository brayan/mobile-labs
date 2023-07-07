import React from "react";
import CustomText from "../../../CustomText";
import { Image, View } from "react-native";
import styles from "./styles";

export default function BasketItem({ item }) {
    return <View style={styles.viewBasketItem}>
        <Image source={item.image} style={styles.imageBasketItem} />
        <CustomText style={styles.textBasketItemName}>{item.name}</CustomText>
    </View>
}
