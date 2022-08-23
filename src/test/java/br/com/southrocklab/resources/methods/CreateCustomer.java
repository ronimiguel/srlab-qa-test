package br.com.southrocklab.resources.methods;

import br.com.southrocklab.resources.tdm.InfoCustomer;

import java.util.HashMap;
import java.util.Map;

public class CreateCustomer {
    InfoCustomer customerData = new InfoCustomer();

    public Map<String, Object> SalvarNovoCustomer() {
        Map<String, Object> customer = new HashMap<String, Object>();
        customer.put("name", customerData.getName());
        customer.put("lastName", customerData.getLastName());
        customer.put("birthDate", customerData.getBirthDate());
        return customer;
    }

}
