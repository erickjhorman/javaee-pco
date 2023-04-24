package org.example;

import org.example.annotations.WorkerQualifier;
import org.example.servicesimpl.User;
import org.example.servicesimpl.WorkerEmployee;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@Stateless
public class AspectEndpoint {

/*    @Inject
    WorkerEmployee worker;*/

    @EJB
    User user;

    @GET
    @Path("/worker/enter1")
    public String workerEnter1() {
        user.getAllPeople();
        return "worker entered";
    }
 /*   @GET
    @Path("/worker/enter")
    public String workerEnter() {
        worker.enterWorkArea();
        return "worker entered";
    }*/

  /*  @GET
    @Path("/supervisor/enter")
    public String supervisorEnter() {
        supervisor.enterWorkArea();
        return "supervisor entered";
    }*/

}
