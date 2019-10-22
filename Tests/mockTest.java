import Models.Drink;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class mockTest {

    @Test
    public void mockTest() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        verify(mockedList).add("one");
        when(mockedList.get(0)).thenReturn("first");
    }
    }
