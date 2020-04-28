package com.tistory.mashupatchitecture

import com.tistory.blackjin.domain.entity.RepoEntity
import com.tistory.blackjin.domain.entity.UserEntity
import com.tistory.blackjin.domain.interactor.usecases.GetRepoUsecase
import com.tistory.blackjin.domain.repository.RepoRepository
import com.tistory.blackjin.domain.repository.UserRepository
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*

class GetRepoUsecaseTest {

    //@Rule
    //@JvmField
    //val testSchedulerRule = RxSchedulerRule()

    @Mock
    private lateinit var userRepository: UserRepository

    @Mock
    private lateinit var repoRepository: RepoRepository

    private lateinit var getRepoUsecase: GetRepoUsecase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getRepoUsecase =
            GetRepoUsecase(userRepository, repoRepository, TrampolineSchedulerProvider())
    }

    @Test
    fun `통신 성공`() {
        val ownerName = "BlackJin"
        val repoName = "Architecture"

        //given
        val user = UserEntity("", "", 10, 10)
        val repo = RepoEntity("", RepoEntity.OwnerEntity("", ""), "", "", Date(), 10)

        Mockito.`when`(userRepository.getUser(ownerName)).thenReturn(Single.just(user))
        Mockito.`when`(repoRepository.getRepo(ownerName, repoName)).thenReturn(Single.just(repo))

        //when
        var result: Pair<UserEntity, RepoEntity>? = null

        getRepoUsecase.get(Pair(ownerName, repoName))
            .subscribe({
                result = it
            }) {
                Assert.fail()
            }

        Assert.assertEquals(Pair(user, repo), result)
    }
}