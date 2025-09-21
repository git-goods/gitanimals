package org.gitanimals.supports.abnormal.commit.similarity

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

const val ABNORMAL_COMMIT_DIMS = 256

@Document(indexName = "abnormal_commit_vector", createIndex = true)
class AbnormalCommitVector(
    @Id
    val id: Long,

    @Field
    val repositoryId: Long,

    @Field
    val sha: String,

    @Field(name = "vector", type = FieldType.Dense_Vector, dims = ABNORMAL_COMMIT_DIMS)
    val vector: List<Float>,
)
