package edu.programacion.avanzada.MariaCruz.ProyectoFinal.patterns.command;

public interface CommandHandler<R, C extends Command<R>> {

    R handle(C command);
}
