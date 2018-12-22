package com.aabsys.practice.home;

import com.aabsys.practice.R;
import com.ramotion.expandingcollection.ECCardData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDataImpl implements ECCardData<String> {

    private String cardTitle;
    private Integer mainBackgroundResource;
    private Integer headBackgroundResource;
    private List<String> listItems;

    public CardDataImpl(String cardTitle, Integer mainBackgroundResource, Integer headBackgroundResource, List<String> listItems) {
        this.mainBackgroundResource = mainBackgroundResource;
        this.headBackgroundResource = headBackgroundResource;
        this.listItems = listItems;
        this.cardTitle = cardTitle;
    }

    @Override
    public Integer getMainBackgroundResource() {
        return mainBackgroundResource;
    }

    @Override
    public Integer getHeadBackgroundResource() {
        return headBackgroundResource;
    }

    @Override
    public List<String> getListItems() {
        return listItems;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public static List<ECCardData> generateExampleData() {
        List<ECCardData> list = new ArrayList<>();
        list.add(new CardDataImpl("Attraction", R.drawable.attractions, R.drawable.attractions_head, createItemsList("Attraction 1")));
        list.add(new CardDataImpl("City Space", R.drawable.city_scape_head, R.drawable.city_scape_head, createItemsList("City Space 2")));
        list.add(new CardDataImpl("Nature of Odisha", R.drawable.nature, R.drawable.nature_head, createItemsList("Nature of Odisha 3")));
        return list;
    }

    private static List<String> createItemsList(String cardName) {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(
                cardName + " - Item 1",
                cardName + " - Item 2",
                cardName + " - Item 3",
                cardName + " - Item 4",
                cardName + " - Item 5",
                cardName + " - Item 6",
                cardName + " - Item 7"
        ));
        return list;
    }

}