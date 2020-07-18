package com.yjs3508.services;

public class ServiceContext {

    private static ActorService actorService;
    private static DirectorService directorService;
    private static MovieService movieService;
    private static SeanceService seanceService;
    private static TicketService ticketService;


    public static ActorService getActorService() {
        synchronized (ServiceContext.class) {
            if (actorService == null) {
                actorService = new ActorService();
            }
        }
        return actorService;
    }

    public static DirectorService getDirectorService() {
        synchronized (ServiceContext.class) {
            if (directorService == null) {
                directorService = new DirectorService();
            }
        }
        return directorService;
    }

    public static MovieService getMovieService() {
        synchronized (ServiceContext.class) {
            if (movieService == null) {
                movieService = new MovieService();
            }
        }
        return movieService;
    }

    public static SeanceService getSeanceService() {
        synchronized (ServiceContext.class) {
            if (seanceService == null) {
                seanceService = new SeanceService();
            }
        }
        return seanceService;
    }

    public static TicketService getTicketService() {
        synchronized (ServiceContext.class) {
            if (ticketService == null) {
                ticketService = new TicketService();
            }
        }
        return ticketService;
    }
}
