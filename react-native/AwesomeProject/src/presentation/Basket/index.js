import React from "react";
import { FlatList, ScrollView, View } from "react-native";
import styles from "./styles";
import BasketHeader from "./components/BasketHeader";
import BasketDetails from "./components/BasketDetails";
import CustomText from "../CustomText";
import BasketItem from "./components/BaskeItem";

export default function Basket({ header, details, items }) {
    return <>
        <FlatList
            ListHeaderComponent={() => {
                return <>
                    <BasketHeader header={header} />

                    <View style={styles.viewBasketBody}>
                        <BasketDetails details={details} />
                        <CustomText style={styles.textBasketItemsTitle}>{items.title}</CustomText>
                    </View>
                </>
            }
            }
            data={items.list}
            renderItem={BasketItem} />
    </>
}
