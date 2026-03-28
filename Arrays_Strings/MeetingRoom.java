package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MeetingRoom {
	
	
	public static int fetchMeetingRoomBySplit(List<List<Integer>>arr) {
		List<Integer>start=new ArrayList<>();
		List<Integer>end=new ArrayList<>();
		for(int i=0;i<arr.size();i++) {
			start.add(arr.get(i).get(0));
			end.add(arr.get(i).get(1));
		}
		Collections.sort(start);
		Collections.sort(end);
		int s=0,e=0;
		int meetingRoom=0;
		int maxMeetingRoom=0;
		while(s<start.size() &&e < end.size()) {
			if(start.get(s)<end.get(e)) {
				meetingRoom++;
				s++;
			}else {
				meetingRoom--;
				e++;
			}
			
			maxMeetingRoom=meetingRoom>maxMeetingRoom?meetingRoom:maxMeetingRoom;
		}
		return maxMeetingRoom;
	}
	
	public static int fetchMeetingRoomWithOutSplit(List<List<Integer>>arr) {
		Map<Integer,Integer>map=new TreeMap<>();
		for(int i=0;i<arr.size();i++) {
			map.put(arr.get(i).get(0), map.getOrDefault(arr.get(i).get(0), 0)+1);
			map.put(arr.get(i).get(1), map.getOrDefault(arr.get(i).get(1), 0)-1);
		}
		int meetingRoom=0;
		int maxMeetingRoom=0;
		for(Map.Entry<Integer,Integer>entry:map.entrySet()) {
			meetingRoom=meetingRoom + entry.getValue();
			
			maxMeetingRoom=meetingRoom>maxMeetingRoom?meetingRoom:maxMeetingRoom;
		}
		return maxMeetingRoom;
	}

	
public static void main(String[] args) {
		
	    System.out.println(fetchMeetingRoomWithOutSplit(Arrays.asList(Arrays.asList(0,30),Arrays.asList(5,10),Arrays.asList(15,20))));	
		}
	
}