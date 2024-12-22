package org.gitanimals.guild.domain

enum class SearchFilter {

    RANDOM {
        override fun sort(guilds: List<Guild>) = guilds
    },

    PEOPLE_ASC {
        override fun sort(guilds: List<Guild>): List<Guild> {
            return guilds.sortedBy { it.getMembers().size }
        }
    },

    PEOPLE_DESC {
        override fun sort(guilds: List<Guild>): List<Guild> {
            return guilds.sortedByDescending { it.getMembers().size }

        }
    },

    CONTRIBUTION_ASC {
        override fun sort(guilds: List<Guild>): List<Guild> {
            return guilds.sortedBy { it.getTotalContributions() }
        }
    },

    CONTRIBUTION_DESC {
        override fun sort(guilds: List<Guild>): List<Guild> {
            return guilds.sortedByDescending { it.getTotalContributions() }
        }
    },
    ;

    abstract fun sort(guilds: List<Guild>): List<Guild>
}
