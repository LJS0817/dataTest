package com.example.isma_soap_calculator;

public class recipeData {

    private boolean isHot;

    private String HotData;

    private String[] data;
    private int[] width_data;

    private cardData[] cards;
    private cardData[] sCards;

    recipeData() {
        data = new String[DATA_TYPE.E_LENGTH.ordinal()];
        isHot = false;
        HotData = "";
        width_data = new int[9];
    }

    recipeData(int size, int size_s) {
        if(isHot) data = new String[DATA_TYPE.E_LENGTH.ordinal()];
        else data = new String[DATA_TYPE.E_LENGTH.ordinal()];
        cards = new cardData[size];
        sCards = new cardData[size_s];
        width_data = new int[9];
    }

    public void setArray_Card(int size) {
        if(cards == null) cards = new cardData[size];
    }

    public void setArray_Card_Super(int size) {
        if(sCards == null) sCards = new cardData[size];
    }

    public String getData(DATA_TYPE dt) {
        try {
            if(data[dt.ordinal()].contains("null")) return "";
            else return data[dt.ordinal()];
        } catch(NullPointerException e) {
            return "";
        }

    }

    public String getData(int dt) {
        if(data[dt].contains("null")) return "";
        else return data[dt];
    }

    public void setData(DATA_TYPE dt, String d) {
        data[dt.ordinal()] = d;
    }

    public void setData(int dt, String d) {
        data[dt] = d;
    }

    public void setWidth_data(int idx, int val) {
        width_data[idx] = val;
    }

    public int getWidth_data(int idx) {
        return width_data[idx];
    }

    public cardData[] getCards() {
        return cards;
    }

    public cardData getCards(int idx) {
        return cards[idx];
    }

    public void setCards(int idx, cardData cd) { cards[idx] = cd; }

    public cardData[] getCards_Super() {
        return sCards;
    }

    public cardData getCards_Super(int idx) {
        return sCards[idx];
    }

    public void setCards_Super(int idx, cardData cd) {
        sCards[idx] = cd;
    }

    public void setHot(String str) {
        if(!isHot) isHot = true;
        if(HotData != ""  && HotData != null && !HotData.isEmpty()) HotData += str;
        else HotData = str;
    }

    public String[] getHot() {
        return HotData.split(",");
    }

    public String getHot_toString() {
        return HotData;
    }

    @Override
    public String toString(){
        String rst = "";
        for(int i = 0; i < data.length; i++) {
            if(i == data.length - 1) rst += (data[i] + "\n");
            else rst += (data[i] + ",");
        }
        for(int i = 0; i < width_data.length; i++) {
            if(i == width_data.length - 1) rst += (Integer.toString(width_data[i]) + "\n");
            else rst += (Integer.toString(width_data[i]) + ",");
        }

        if(cards.length == 0)
        {
            rst += "\n";
        }
        else {
            for(int i = 0; i < cards.length; i++) {
                if(cards[i] == null || cards[i].toString().isEmpty()) {
                    rst += "\n";
                    break;
                }
                if(i == cards.length - 1) rst += (cards[i].toString() + "\n");
                else rst += (cards[i].toString() + "`");
            }
        }

        if(sCards.length == 0) {
            rst += "\n";
        }
        else {
            for(int i = 0; i < sCards.length; i++) {
                if(isHot){
                    if(sCards[i] == null || sCards[i].toString().isEmpty()) {
                        rst += "\n";
                        break;
                    }
                }
                else{
                    if(sCards[i] == null) break;
                    if(sCards[i].toString().isEmpty()) break;
                }
                if(i == sCards.length - 1) rst += (sCards[i].toString() + "\n");
                else rst += (sCards[i].toString() + "`");
            }
        }

        if(isHot) {
            if(sCards == null || sCards.length == 0) {
                rst += "\n";
            }
            rst += HotData + "\n";
        }
        return rst;
    }
}
