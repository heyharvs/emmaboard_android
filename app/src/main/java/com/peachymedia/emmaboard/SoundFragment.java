package com.peachymedia.emmaboard;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SoundFragment extends Fragment {


    public SoundFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_sound, container, false);
        LinearLayout buttons = (LinearLayout) layout.findViewById(R.id.soundbuttons);
        Integer soundset = getArguments().getInt("soundset");
        Map<String, Integer> sounds = new HashMap<String, Integer>();

        switch (soundset) {
            case 0:
                sounds.put("Again!", R.raw.again);
                sounds.put("Bless You", R.raw.bless_you);
                sounds.put("Can I Try?", R.raw.can_i_try);
                sounds.put("Dad, Like This!", R.raw.dad_like_this);
                sounds.put("I Can't Do It", R.raw.i_cant_do_it);
                sounds.put("I Did It!", R.raw.i_did_it);
                sounds.put("I Dunno", R.raw.i_dunno);
                sounds.put("No Not Today", R.raw.no_not_today);
                sounds.put("Yes", R.raw.yes);
                sounds.put("no", R.raw.no);
                sounds.put("yay", R.raw.yay);
                sounds.put("Thank You!", R.raw.thank_you);
                break;

            case 1:
                sounds.put("brooke", R.raw.brooke);
                sounds.put("ethan", R.raw.ethan);
                sounds.put("papa", R.raw.papa);
                sounds.put("mama", R.raw.mama);
                sounds.put("Emma Jayne Valentine", R.raw.ejv);
                break;

            case 2:
                sounds.put("laugh", R.raw.laugh);
                sounds.put("laugh 2", R.raw.laugh_2);
                sounds.put("big laugh", R.raw.big_laugh);
                sounds.put("big laugh 2", R.raw.big_laugh_2);
                sounds.put("big laugh 3", R.raw.big_laugh_3);
                sounds.put("evil laugh", R.raw.evil_laugh);
                sounds.put("evil laugh 2", R.raw.evil_laugh_2);
                sounds.put("i love you", R.raw.i_love_you);
                sounds.put("i love you (soft)", R.raw.i_love_you_soft);
                sounds.put("i love you (loud)", R.raw.i_love_you_loud);
                break;

            case 3:
                sounds.put("ok bye", R.raw.ok_bye);
                sounds.put("hurry up", R.raw.hurry_up);
                sounds.put("abc song", R.raw.abc_song);
                sounds.put("let it go", R.raw.let_it_go);
                sounds.put("itsy bitsy spider", R.raw.itsy_bitsy_spider);
                sounds.put("twinkle twinkle little star", R.raw.twinkle_little_star);
                sounds.put("let it go (long version)", R.raw.let_it_go_long_version);
                sounds.put("in love with the coco", R.raw.im_in_love_with_the_coco);


                break;

            case 4:
                sounds.put("belly button", R.raw.belly_button);
                sounds.put("blues clues", R.raw.blues_clues);
                sounds.put("bottle milk", R.raw.bottle_milk);
                sounds.put("climbing", R.raw.climbing);
                sounds.put("climbing beanstalk", R.raw.climbing_beanstalk);
                sounds.put("get down", R.raw.get_down);
                sounds.put("happy birthday", R.raw.happy_birthday);
                sounds.put("i like your shirt", R.raw.i_like_your_shirt);
                sounds.put("i'm big", R.raw.im_big);
                sounds.put("i'm tired", R.raw.im_tired);
                sounds.put("it's heavy", R.raw.its_heavy);
                sounds.put("mmm, smell good", R.raw.mm_smell_good);
                sounds.put("smell stinky", R.raw.smell_stinky);
                sounds.put("tiny ugly germs", R.raw.tiny_ugly_germs);
                sounds.put("yo gabba gabba", R.raw.yo_gabba_gabba);
                sounds.put("you want checkup?", R.raw.you_want_checkup);
                sounds.put("drop da bass!", R.raw.drop_the_bass);
                sounds.put("deez nuts!", R.raw.deez_nuts);
                break;
        }

        for (Map.Entry<String, Integer> entry : sounds.entrySet()) {
            String key = entry.getKey();
            final Integer value = entry.getValue();

            Button button = new Button(getActivity());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer player = MediaPlayer.create(getActivity(), value);
                    player.start();
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.stop();
                            mp.release();
                        }
                    });
                }
            });
            button.setText(key);
            buttons.addView(button);
        }

        return layout;
    }

}
