package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.ReadOnlyWordBank;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of WordBank data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private WordBankStorage wordBankStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code WordBankStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(WordBankStorage wordBankStorage, UserPrefsStorage userPrefsStorage) {
        super();
        this.wordBankStorage = wordBankStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }

    // ================ WordBank methods ==============================

    @Override
    public Path getAddressBookFilePath() {
        return wordBankStorage.getAddressBookFilePath();
    }

    @Override
    public Optional<ReadOnlyWordBank> readAddressBook() throws DataConversionException, IOException {
        return readAddressBook(wordBankStorage.getAddressBookFilePath());
    }

    @Override
    public Optional<ReadOnlyWordBank> readAddressBook(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return wordBankStorage.readAddressBook(filePath);
    }

    @Override
    public void saveAddressBook(ReadOnlyWordBank addressBook) throws IOException {
        saveAddressBook(addressBook, wordBankStorage.getAddressBookFilePath());
    }

    @Override
    public void saveAddressBook(ReadOnlyWordBank addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        wordBankStorage.saveAddressBook(addressBook, filePath);
    }

}
