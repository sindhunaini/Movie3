
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.movieapp1.Getservice.MovieService;
import com.stackroute.movieapp1.Getservice.dbMovieService;
import com.stackroute.movieapp1.model.MovieModel;
import com.stackroute.movieapp1.repository.MovieRdmsRepo;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class Testfile2 {
   
     
      private dbMovieService dbmovieService;
      private MovieService movieService;
       @Mock
       private MovieRdmsRepo movieRdmsRepo;
       @Mock
       private MovieModel movieModel;
       @Before
       public void setupMock() {
           MockitoAnnotations.initMocks(this);
           dbmovieService=new dbMovieService();
           dbmovieService.setMovieRdmsrepo(movieRdmsRepo);
       }
       @Test
       //Test by id
       public void TestgetById() throws Exception {
           // Arrange
           when(movieRdmsRepo.findById("2")).thenReturn(movieModel);
           // Act
           MovieModel retrievedUser = dbmovieService.findById("2");
           // Assert
           assertThat(retrievedUser, is(equalTo(movieModel)));
      }
       
       @Test
       public void TestUpdate() throws Exception {
           // Arrange
           when(movieRdmsRepo.save(movieModel)).thenReturn(movieModel);
           // Act
           dbmovieService.update(movieModel);
           // Assert
           assertThat(movieRdmsRepo.findOne("1"), is(movieRdmsRepo.findOne("1")));
       }
       @Test
       public void TestDelete() throws Exception {
           // Arrange
           doNothing().when(movieRdmsRepo).delete("1");
           MovieRdmsRepo my = Mockito.mock(MovieRdmsRepo.class);
           // Act
          dbmovieService.delete("1");
           // Assert
           verify(movieRdmsRepo, times(1)).delete("1");
       }
   }