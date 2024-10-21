package br.edu.ifpr.web.exceptions;

public class UnmappedEndpoint extends Exception {

    public UnmappedEndpoint() {
        super("The requested endpoint mapping could not be found");
    }

}
