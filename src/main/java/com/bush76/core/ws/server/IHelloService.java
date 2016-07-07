package com.bush76.core.ws.server;

import java.util.List;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bush76.core.entity.User;
import com.bush76.core.ws.util.MapAdapter;
import com.bush76.core.ws.util.XStreamAdapter;  

@WebService
public interface IHelloService {

    public String say(@WebParam(name="name") String name);
    
    public List<User> list();  
    
    @XmlJavaTypeAdapter(MapAdapter.class)  
    public Map<String, User> getUserMap();
    
    @XmlJavaTypeAdapter(MapAdapter.class)  
    public Map<String, Object> getMapObject();
    
    public String saveUser(User user);
    
    @XmlJavaTypeAdapter(XStreamAdapter.class)  
    public Map<String,Object> getUser();
    
}