public class FactoryCommands {
    public Commands choose (String c) {
        switch (c) {
            case "LIST":
                return new ComandaAfisare();
            case "LISTEN":
                return new ComandaAscultare();
            case "RECOMMEND":
                return new ComandaRecomandari();
            case "SURPRISE":
                return new ComandaSurpriza();
            case "ADD":
                return new ComandaAdaugare();
            case "DELETE":
                return new ComandaStergere();
            default:
                return null;
        }
    }
}
