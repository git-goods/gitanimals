package org.gitanimals.guild.domain

fun guild(
    id: Long = 1L,
    guildIcon: String = "default_icon.png",
    title: String = "Default Guild Title",
    body: String = "Default guild description.",
    leader: Leader = leader(),
    members: MutableSet<Member> = mutableSetOf(),
    waitMembers: MutableSet<WaitMember> = mutableSetOf(),
    farmType: GuildFarmType = GuildFarmType.DUMMY,
    autoJoin: Boolean = true,
): Guild {
    return Guild(
        id = id,
        guildIcon = guildIcon,
        title = title,
        body = body,
        leader = leader,
        members = members,
        waitMembers = waitMembers,
        farmType = farmType,
        autoJoin = autoJoin,
    )
}

fun leader(
    userId: Long = 1L,
    name: String = "Default Leader",
    personaId: Long = 1L,
    contributions: Long = 0L,
    personaType: String = "GOOSE",
): Leader {
    return Leader(
        userId = userId,
        name = name,
        personaId = personaId,
        contributions = contributions,
        personaType = personaType,
    )
}

fun member(
    guild: Guild,
    userId: Long = 2L,
    name: String = "DefaultName",
    personaId: Long = 200L,
    contributions: Long = 500L,
    personaType: String = "GOOSE",
): Member {
    return Member.create(
        guild = guild,
        userId = userId,
        name = name,
        personaId = personaId,
        contributions = contributions,
        personaType = personaType,
    )
}
