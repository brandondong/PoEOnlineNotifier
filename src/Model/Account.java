package Model;

import DataProvider.AccountDataProvider;
import DataProvider.CharacterDataProvider;
import Model.Exceptions.NoCharacterExistsException;
import Parsers.AccountParser;
import Parsers.CharacterParser;

/**
 * Created by Brandon on 2015-08-26.
 */
public class Account extends Observable {

    private String charName;
    private String accountName;
    private boolean isOnline;

    public Account(String charName) throws NoCharacterExistsException {
        this.charName = charName;

        for (String league : App.LEAGUE_NAMES) {
            try {
                String response = new CharacterDataProvider(charName, league).dataSourceToString();
                accountName = CharacterParser.getAccountNameFromCharacter(response);
            } catch (Exception e) {

            }
        }
        if (accountName == null) {
            throw new NoCharacterExistsException();
        }

        isOnline = findOnlineStatus();
    }

    // Modifies: this
    // Effects: updates the online status and notifies observers if the status was changed
    public void updateStatus() {
        boolean newStatus = findOnlineStatus();
        if (!isOnline == newStatus) {
            isOnline = newStatus;
            notifyObservers(charName, isOnline);
        }
    }

    // Effects: returns the online status of this account
    private boolean findOnlineStatus() {
        for (String league : App.LEAGUE_NAMES) {
            try {
                String response = new AccountDataProvider(accountName, league).dataSourceToString();
                if (AccountParser.isAccountOnline(response)) {
                    return true;
                }
            } catch (Exception e) {

            }
        }
        return false;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public String getCharName() {
        return charName;
    }

    public String getAccountName() {
        return accountName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return !(charName != null ? !charName.equals(account.charName) : account.charName != null);

    }

    @Override
    public int hashCode() {
        return charName != null ? charName.hashCode() : 0;
    }
}
