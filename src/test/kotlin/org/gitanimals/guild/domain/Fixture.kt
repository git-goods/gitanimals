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
): Leader {
    return Leader(
        userId = userId,
        name = name,
        personaId = personaId,
        contributions = contributions
    )
}
