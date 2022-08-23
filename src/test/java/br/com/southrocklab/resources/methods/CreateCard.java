package br.com.southrocklab.resources.methods;

import br.com.southrocklab.resources.tdm.InfoCard;

import java.util.HashMap;
import java.util.Map;

public class CreateCard {
    InfoCard cardData = new InfoCard();

    public Map<String, Object> salvarNovo(int customerId){
        Map<String, Object> card = new HashMap<String, Object>();
        card.put("brand", cardData.getBrand());
        card.put("cvc", cardData.getCvc());
        card.put("expirationMoth", cardData.getExpMonth());
        card.put("expirationYear", cardData.getExpYear());
        card.put("holderName", cardData.getHolderName());
        card.put("number", cardData.getCardNumber());
        card.put("customerId", customerId);
        return card;
    }

    public Map<String, Object> comCvcMaior(int customerId){
        Map<String, Object> card = new HashMap<String, Object>();
        card.put("brand", cardData.getBrand());
        card.put("cvc", cardData.getCvcMaior());
        card.put("expirationMoth", cardData.getExpMonth());
        card.put("expirationYear", cardData.getExpYear());
        card.put("holderName", cardData.getHolderName());
        card.put("number", cardData.getCardNumber());
        card.put("customerId", customerId);
        return card;
    }

    public Map<String, Object> comExpMonthMaior(int customerId){
        Map<String, Object> card = new HashMap<String, Object>();
        card.put("brand", cardData.getBrand());
        card.put("cvc", cardData.getCvc());
        card.put("expirationMoth", cardData.getExpMonthMaior());
        card.put("expirationYear", cardData.getExpYear());
        card.put("holderName", cardData.getHolderName());
        card.put("number", cardData.getCardNumber());
        card.put("customerId", customerId);
        return card;
    }

}
