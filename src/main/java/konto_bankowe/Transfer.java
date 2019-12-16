package konto_bankowe;

public class Transfer extends Transaction {

    private boolean instant;

    public boolean isInstant() {
        return instant;
    }

    public void setInstant(boolean instant) {
        this.instant = instant;
    }

}
