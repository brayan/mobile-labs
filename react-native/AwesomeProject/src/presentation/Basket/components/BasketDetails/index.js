import React from "react";
import { Image, View } from "react-native";
import styles from "./styles";
import CustomText from "../../../CustomText";
import CustomButton from "../../../CustomButton";

export default function BasketDetails({details}) {
    return <>
        <CustomText style={styles.textProductName}>{details.name}</CustomText>

        <View style={styles.viewFarmNameAndImage}>
            <Image source={details.farm.logo} style={styles.imageFarmLogo}></Image>
            <CustomText style={styles.textFarmName}>{details.farm.name}</CustomText>
        </View>

        <CustomText style={styles.textDescription}>{details.description}</CustomText>
        <CustomText style={styles.textPrice}>{details.price}</CustomText>

        <CustomButton text={details.button} />
    </>
}
