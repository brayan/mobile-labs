import React from "react";
import styles from "./styles";
import imageTopCover from '../../../../../assets/topo.png'
import { Image } from "react-native";
import CustomText from "../../../CustomText";

export default function BasketHeader({header}) {
    return <>
        <Image source={imageTopCover} style={styles.imageTopCover} />
        <CustomText style={styles.textBasketScreenTitle}>{header.title}</CustomText>
    </>
}
