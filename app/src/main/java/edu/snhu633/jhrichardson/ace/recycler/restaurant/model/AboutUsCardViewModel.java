package edu.snhu633.jhrichardson.ace.recycler.restaurant.model;

import java.util.Objects;

public class AboutUsCardViewModel {

    int cardIconIdPlaceholder;
    String cardTitlePlaceholder;
    String cardNamePlaceholder;
    String cardTextPlaceholder;

    public AboutUsCardViewModel(int cardIconIdPlaceholder, String cardTitlePlaceholder,
                                String cardNamePlaceholder, String cardTextPlaceholder) {
        this.cardIconIdPlaceholder = cardIconIdPlaceholder;
        this.cardTitlePlaceholder = cardTitlePlaceholder;
        this.cardNamePlaceholder = cardNamePlaceholder;
        this.cardTextPlaceholder = cardTextPlaceholder;
    }

    public int getCardIconIdPlaceholder() {
        return cardIconIdPlaceholder;
    }

    public void setCardIconIdPlaceholder(int cardIconIdPlaceholder) {
        this.cardIconIdPlaceholder = cardIconIdPlaceholder;
    }

    public String getCardTitlePlaceholder() {
        return cardTitlePlaceholder;
    }

    public void setCardTitlePlaceholder(String cardTitlePlaceholder) {
        this.cardTitlePlaceholder = cardTitlePlaceholder;
    }

    public String getCardNamePlaceholder() {
        return cardNamePlaceholder;
    }

    public void setCardNamePlaceholder(String cardNamePlaceholder) {
        this.cardNamePlaceholder = cardNamePlaceholder;
    }

    public String getCardTextPlaceholder() {
        return cardTextPlaceholder;
    }

    public void setCardTextPlaceholder(String cardTextPlaceholder) {
        this.cardTextPlaceholder = cardTextPlaceholder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AboutUsCardViewModel that = (AboutUsCardViewModel) o;
        return cardIconIdPlaceholder == that.cardIconIdPlaceholder &&
                cardTitlePlaceholder.equals(that.cardTitlePlaceholder) &&
                cardNamePlaceholder.equals(that.cardNamePlaceholder) &&
                cardTextPlaceholder.equals(that.cardTextPlaceholder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardIconIdPlaceholder, cardTitlePlaceholder,
                cardNamePlaceholder, cardTextPlaceholder);
    }

    @Override
    public String toString() {
        return "AboutUsCardViewModel{" +
                "cardIconIdPlaceholder=" + cardIconIdPlaceholder +
                ", cardTitlePlaceholder='" + cardTitlePlaceholder + '\'' +
                ", cardNamePlaceholder='" + cardNamePlaceholder + '\'' +
                ", cardTextPlaceholder='" + cardTextPlaceholder + '\'' +
                '}';
    }


}
