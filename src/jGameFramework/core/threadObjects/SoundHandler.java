package jGameFramework.core.threadObjects;

import jGameFramework.collections.ResourceKeyMap;

import javax.sound.sampled.AudioInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Plays sound files.
 *
 * This Handler is different from the MusicHandler because it
 * DOES NOT closes clips that are not currently used. The play()
 * method will play the sounds with less delay, but this will
 * use more memory.
 *
 * @author Jérémie Beaudoin-Dion
 */
class SoundHandler {

    private ResourceKeyMap<String, AudioInputStream> soundMap;

    private List<DisposableClip> soundClips;

    SoundHandler(Map<String, AudioInputStream> soundMap){
        this.soundMap = new ResourceKeyMap<>(soundMap);
        this.soundClips = new LinkedList<>();
        openAllClips();
    }

    private void openAllClips(){
        for (String key : soundMap.getAllKeys()){
            soundClips.add(new DisposableClip(key, soundMap.get(key)));
        }
    }

    void closeAll(){
        for(DisposableClip clip : soundClips){
            clip.close();
        }
    }

    void play(String id) {
        for(DisposableClip clip: soundClips){
            if(clip.isEqualTo(id)){
                clip.play(0);
            }
        }
    }

}
