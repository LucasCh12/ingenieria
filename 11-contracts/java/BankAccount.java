/**
 *  INVARIANT:  accountNumber != null && !accountNumber.isEmpty()
 *              balance >= 0
 *              isOpen !=null
 */
public class BankAccount {

    private String accountNumber;
    private double balance;
    private boolean isOpen;

    /**
     * PRECONDITION :
     * - accountNumber != null && !accountNumber.isEmpty().
     * - initialDeposit >= 0.
     * POSTCONDITION :
     * - Se crea una cuenta de banco, con deposit == initialDeposit.
     */
    public BankAccount(String accountNumber, double initialDeposit) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException(
                "El numero de cuenta no puede ser nulo o estar vacio"
            );
        }
        if (initialDeposit < 0) {
            throw new IllegalArgumentException(
                "El deposito inicial no puede ser menor a 0"
            );
        }

        this.accountNumber = accountNumber;
        this.initialDeposit = initialDeposit;
        this.isOpen = true;
    }

    /**
     * PRECONDITION :
     * - amount > 0.
     * - isOpen() == true (la cuenta debe estar abierta).
     * POSTCONDITION :
     * El monto anterior de la cuenta es aumentado por el amount, osea updatedBalance == oldBalance + amount.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "No se puede depositar un monto menor o igual a 0"
            );
        }

        if (!isOpen) {
            throw new IllegalStateException(
                "No se puede depositar en una cuenta cerrada"
            );
        }

        double oldBalance = this.balance;
        this.balance += amount;

        assert balance ==
        oldBalance + amount : "El balance no se actualizo correctamente";

        assert repOk() : "Invariante de clase violada";
    }

    /**
     * PRECONDITION :
     * - isOpen == true.
     * - amount <= balance && amount >0(no se puede retirar mas dinero del que dispongas o retirar 0)
     * POSTCONDITION :
     * - Se le va a restar al balance de la cuenta el amount extraido.
     * - balance = oldBalance - amount.
     */
    public void withdraw(double amount) {
        if (amount > this.balance || amount <= 0) {
            throw new IllegalArgumentException(
                "No se puede retirar mas dinero del que se dispone o retirar menos que 0"
            );
        }

        if (!isOpen) {
            throw new IllegalStateException(
                "No se puede retirar dinero en una cuenta cerrada"
            );
        }

        double oldBalance = this.balance;
        balance -= amount;

        assert balance ==
        oldBalance - amount : "No se pudo retirar dinero correctarmente";

        assert repOK() : "Invariante de clase violada";
    }

    /**
     * POSTCONDITION : Se devuelve el balance actual de la cuenta
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * PRECONDITION :
     *  - isOpen == true. La cuenta debe estar abierta para cerrarse.
     * POSTCONDITION :
     * - isOpen = false.
     * - balance = 0.
     * - La cuenta no acepta mas operaciones.
     */
    public void close() {
        if (!isOpen) {
            throw new IllegalStateException(
                "No se puede cerrar una cuenta ya cerrada"
            );
        }
        isOpen = false;
        balance = 0;

        assert isOpen == false : "La cuenta no se cerro correctamente";
        assert balance == 0 : "El balance no se establecio a 0";
        assert repOK() : "Invariante de clase violada";
    }

    private boolean repOK() {
        return (
            accountNumber != null &&
            (!accountNumber.isEmpty()) &&
            (this.balance >= 0)
                this.b
        );
    }
}
