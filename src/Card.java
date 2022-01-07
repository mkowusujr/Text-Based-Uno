public class Card {
    private char color;
    private int value;
    private boolean faceUp;

    public Card(char color, int value) {
        this.color = color;
        this.value = value;
        faceUp = false;
    }

    public boolean isFaceUp() {
        if (faceUp)
            return true;
        else
            return faceUp;
    }

    public void flipCard() {
        faceUp = !faceUp;
    }

    public char getColor(){
        return color;
    }

    public int getValue() {
        return value;
    }

    public void changeColor(char color) {
        if (value > 12) {
            this.color = color;
        }
    }

    public void changeColor(String color) {
        if (value > 12) {
            this.color = color.charAt(0);
        }
    }

    public boolean canPlayCard(Deck playingDeck, Player player) {
        if (this.equals(playingDeck.getTopOfDiscardDeck())) {
            System.out.println("You played a " + this + " card");
            playingDeck.addToDiscardCard(this);
            return true;
        } else {
            player.receiveHand(this);
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Card) {
            Card cardPlayed = (Card) other;
            if (this.color == cardPlayed.color || this.color == 's') {
                return true;
            }
            return this.value == cardPlayed.value;
        }
        return false;
    }

    @Override
    public String toString() {
        if (isFaceUp() == true) {
            if (value == 10)
                return color + "x";
            else if (value == 11)
                return color + "<>";
            else if (value == 12)
                return color + "+2";
            else if (value == 13)
                return color + "w";
            else if (value == 14)
                return color + "+4";
            else
                return color + String.valueOf(value);
        } else {
            return "u";
        }
    }
}