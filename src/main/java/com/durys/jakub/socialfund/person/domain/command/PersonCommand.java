package com.durys.jakub.socialfund.person.domain.command;

import com.durys.jakub.socialfund.cqrs.Command;
import com.durys.jakub.socialfund.person.domain.PersonType;

import java.time.LocalDate;
import java.util.UUID;

public sealed interface PersonCommand extends Command {

    record ReportPersonCommand(String firstName, String lastName, LocalDate birthdayDate, PersonType type) implements PersonCommand {}

    record ChangePersonType(UUID personId, PersonType type) implements PersonCommand {}
}
