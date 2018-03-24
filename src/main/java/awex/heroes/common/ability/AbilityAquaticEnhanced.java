package awex.heroes.common.ability;

import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AbilityAquaticEnhanced extends Ability<IAbility> {
    private static int cooldown = 0;
    public AbilityAquaticEnhanced(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IAbility instance, TickEvent.Phase phase) {
        super.onUpdate(entity, hero, instance, phase);
        if (phase == TickEvent.Phase.END) {
            EntityPlayer player = (EntityPlayer) entity;

            if (player.isInWater() && !player.capabilities.isFlying)
            {
                player.motionX *= 1.325D;
                player.motionY *= 1.25D;
                player.motionZ *= 1.325D;
                player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20, 0, false));
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20, 1, false));
                List<String> randomsg = Arrays.asList("\"Automatic\" simply means that you cannot repair it yourself." ,

                        "90% of everything is crud." ,

                        "A Project Manager is like the madam in a brothel. His job is to see" ,
                        "that everything comes off right." ,

                        "A Smith & Wesson always beats four aces." ,

                        "A bird in hand is safer than one overhead." ,

                        "A bird in the hand is worth about three Kleenex." ,

                        "A child's ability to endure likely stems from his ignorance of" ,
                        "alternatives." ,

                        "A clean desk is a sign of a sick mind." ,

                        "A closed mouth says nothing wrong; a closed mind does nothing right." ,

                        "A complex system that works is invariably found to have evolved from a" ,
                        "More: [Y], [N], [NS]? nssimple system that worked." ,

                        "A computer makes as many mistakes in one second as three men working" ,
                        "for thirty years straight." ,

                        "A conference is simply an admission that you want somebody else to" ,
                        "join you in your troubles." ,

                        "A dog is a dog except when he is facing you. Then he is Mr. Dog." ,

                        "A fellow who is always declaring that he is no fool usually harbors" ,
                        "suspicions to the contrary." ,

                        "A fool and his money are some party." ,

                        "A friend in power is a friend lost." ,

                        "A good listener not only is popular everywhere but also, after a" ,
                        "while, knows something." ,

                        "A great deal of money is never enough once you have it." ,

                        "A hunch is creativity trying to tell you something." ,

                        "A liberalism incapable of fiscal self-discipline brings about a" ,
                        "radical conservatism conspicuous for its selfishness and" ,
                        "insensitivity." ,

                        "A major failure will not occur until after the unit has passed final" ,
                        "inspection." ,

                        "A man does not look behind the door unless he has stood there" ,
                        "himself." ,

                        "A man will believe anything that does not cost him anything." ,

                        "A meeting is an event at which the minutes are kept and the hours are" ,
                        "lost." ,

                        "A miser is a fellow who lives within his income. He is also called a" ,
                        "magician." ,

                        "A misplaced decimal point will always end up where it will do the" ,
                        "greatest damage." ,
                        "" ,
                        "A narrow mind has a broad tongue." ,

                        "A neurotic builds castles in the air." ,
                        "A psychotic lives in castles in the air." ,
                        "And a psychiatrist is the guy who collects the rent." ,

                        "A perfectly calm day will turn gusty the instant you drop a $20 bill." ,

                        "A pipe gives a wise man time to think and a fool something to stick in" ,
                        "his mouth." ,

                        "A politician's most important ability is to foretell what will happen" ,
                        "tomorrow and next month and next year - and to explain afterwards why" ,
                        "it didn't happen." ,


                        "A seeming ignorance is often a most necessary part of worldly" ,
                        "knowledge." ,

                        "A sense of decency is often a decent man's undoing." ,

                        "A short cut is the longest distance between two points." ,

                        "A stockbroker is someone who invests your money until it is all gone." ,

                        "A synonym is a word you use when you can't spell the other one." ,

                        "A waist is a terrible thing to mind." ,

                        "A yacht is a hole in the water, lined with wood, steel, or fiberglass," ,
                        "through which one pours all his money." ,

                        "Academic rivalries are so intense because the stakes are so small." ,

                        "Activity is the politician's substitute for achievement." ,

                        "Adam Smith revisited: Work creates Wealth, which is then Redistributed" ,
                        "in the holy name of Social Justice. That is to say, what is mine is" ,
                        "yours, and his, and hers, and theirs..." ,

                        "Adventure is no more than discomfort and annoyance recollected in the" ,
                        "safety of reminiscence." ,

                        "After all is said and done, a hell of a lot more is said than done." ,

                        "Against stupidity, the gods themselves contend in vain." ,

                        "All great discoveries are made by mistake." ,

                        "All skill is in vain when an angel pees in the barrel of your rifle." ,

                        "All things are possible." ,
                        "Except skiing through a revolving door." ,

                        "All things being equal, a fat person uses more soap than a thin" ,
                        "person." ,

                        "All turtle thoughts are of turtle." ,

                        "All warranties expire upon payment of invoice." ,

                        "All work and no play make Jack a dull boy and Jill a wealthy widow." ,

                        "All's well that ends." ,
                        "" ,
                        "Almost everything in life is easier to get into than out of." ,

                        "Although I may disagree with what you say, I will defend to the death" ,
                        "your right to hear me tell you how wrong you are." ,

                        "Always address your elders with respect; they could leave you a" ,
                        "fortune." ,

                        "Always convice those whom you are about to deceive that you are acting" ,
                        "in their best interests." ,

                        "Always forgive your enemies - nothing else annoys them as much." ,

                        "Always mistrust a subordinate who never finds fault with his boss." ,

                        "Ambition is the curse of the political class." ,

                        "Among economists, the real world is generally considered to be a" ,
                        "special case." ,

                        "An easily understood, workable falsehood is more useful than a" ,
                        "complex, incomprehensible truth." ,

                        "An economy cannot afford high tech unless it has a basic structure of" ,
                        "other industry to provide the savings that will support high tech" ,
                        "until it begins to pay off." ,

                        "An efficient bureaucracy is the greatest threat to liberty." ,

                        "An elephant is a mouse built to government specifications." ,

                        "An expert is one who knows more and more about less and less until he" ,
                        "knows absolutely everything about nothing." ,

                        "An infinite number of mediocrities do not add up to one genius." ,

                        "An open mouth oft-times accompanies a closed mind." ,

                        "An unhappy crew makes for a dangerous voyage." ,

                        "Anger is never without an argument, or with a good one." ,

                        "Any appetite is its own excuse for existing." ,

                        "Any component, when inadvertently dropped, will roll into a hiding" ,
                        "place, the inaccessibility of which is proportional to the square of" ,
                        "the component's irreplaceability." ,

                        "Any contract drawn in more than 50 words contains at least one" ,
                        "loophole." ,

                        "Any given computer program, when running, is obsolete." ,

                        "Any machine design must contain at least one part which is obsolete," ,
                        "two parts which are unobtainable, and three parts which are still" ,
                        "under development." ,

                        "Any simple theory will be worded in the most complicated terms." ,

                        "Any sufficiently advanced technology is indistinguishable from magic." ,

                        "Anyone can handle a crisis." ,
                        "It's everyday living that kills you." ,
                        "" ,
                        "Anyone in good enough condition to run three miles a day is in good" ,
                        "enough condition not to have to." ,

                        "Art is a passion pursued with discipline; science is a discipline" ,
                        "pursued with passion." ,

                        "As scarce as truth is, the supply invariably exceeds the demand." ,

                        "As the rabbit said, if that ain't a wolf, it's a hell of a big dog." ,

                        "Ask your children what they want for dinner only if they are buying." ,

                        "Assumptions, so often full of holes, remain precious to the" ,
                        "convinced." ,

                        "At best, life is a spiral and never a pendulum. What has been done" ,
                        "cannot be undone." ,

                        "Bad weather forecasts are more often right than good ones." ,

                        "Bankers are the assassins of hope." ,

                        "Basic research is what you do when you don't know what you are doing." ,

                        "Be a corporate good citizen; hire the morally handicapped." ,

                        "Be kind to your web-footed friends; that duck may be a buyer." ,

                        "There's no intelligent life down here." ,

                        "Beauty is only skin deep, but ugly goes right to the bone." ,

                        "Behind every successful man is an astonished mother-in-law." ,

                        "Being king is not much fun if no one knows you are one." ,

                        "Bend the facts to fit the conclusion. It's easier that way." ,

                        "Beware of all enterprises requiring new clothes." ,

                        "Black holes are outa sight!" ,

                        "Blessed are the censors, for they shall inhibit the earth." ,

                        "Blessed are the meek for they shall inherit the crap." ,

                        "Blessed are the young, for they shall inherit the national debt." ,

                        "Blessed be he who is called a big wheel, for he goeth around in" ,
                        "circles." ,

                        "Bosses come and bosses go, but a good secretary lasts forever." ,

                        "Bullshit baffles brains." ,

                        "By the time most of us have money to burn, our fire's gone out." ,

                        "By working faithfully 8 hours a day, you may eventually get to be a" ,
                        "boss and work 12 hours a day." ,

                        "Celibacy is not hereditary." ,

                        "Cheer up." ,
                        "The first hundred years are the hardest!" ,
                        "" ,
                        "Children are a comfort in your old age, and they will even help you" ,
                        "reach it." ,

                        "Civil servants are neither civil nor servile." ,

                        "Common sense is instinct. Enough of it is genius." ,

                        "Computers are unreliable, but humans are even more unreliable. Any" ,
                        "system which depends upon human reliability is unreliable. You can" ,
                        "rely on it." ,

                        "Confidence is the feeling you had before you knew better." ,

                        "Construct a system that even a fool can use and only a fool will want" ,
                        "to use it." ,

                        "Crime is merely politics without the excuses." ,

                        "Crisis management works beautifully until an actual crisis occurs." ,

                        "Da trouble wit computers is, dey got no sense of humor." ,

                        "Days you attend top-level meetings and days you get hiccups tend to" ,
                        "fall on the same dates." ,

                        "Degeneration and evolution are not the same thing." ,

                        "Desperate diseases require desperate remedies." ,

                        "Did you know that if you maintain a cholesterol-free diet, your body" ,
                        "makes its own cholesterol." ,

                        "Diogenes is still searching." ,

                        "Distrust your first impressions; they are invariably too favorable." ,

                        "Don't be afraid to take a big step. You cannot cross a chasm in two" ,
                        "small steps." ,

                        "Don't be so humble...you aren't that great." ,

                        "Don't get married if you are afraid of solitude." ,

                        "Don't hit a man when he's down unless you are damned certain he won't" ,
                        "get up." ,

                        "Don't wear earmuffs in a bed of rattlesnakes." ,

                        "Don't worry about what other people are thinking of you. They're too" ,
                        "busy worrying about what you are thinking of them." ,

                        "Dr. Faustus, call your service." ,

                        "During Britain's \"brain drain,\" not a single politician left the" ,
                        "country." ,

                        "Economics is the only calling in which one can have a lifetime" ,
                        "reputation as an expert without ever once being right." ,

                        "Education confers understanding, knowledge, and competence; schools" ,
                        "confer degrees." ,

                        "Enthusiasm wanes, but dullness lasts forever." ,

                        "Eternity is a terrible thought...where will it all end" ,

                        "Even Mason and Dixon had to draw the line somewhere." ,

                        "Even the most faithful believer can serve a false god." ,

                        "Every calling is great when greatly pursued." ,

                        "Every family tree has some sap." ,

                        "Every institution tends to perish through an excess of its own" ,
                        "policy." ,

                        "Every society professes the existence of inalienable human rights;" ,
                        "most, however, are somewhat vague as to just what they are." ,

                        "Everybody's death simplifies life for someone." ,

                        "Everyone has a scheme for getting rich that will not work." ,

                        "Everything comes to he who waits - providing he has either infinite" ,
                        "patience or infinite wealth." ,

                        "Everything east of the San Andreas Fault will eventually plunge into" ,
                        "the Atlantic Ocean." ,

                        "Everything not forbidden by the laws of Nature is mandatory. Trouble" ,
                        "is, nearly everything is forbidden." ,

                        "Example is not the main thing in influencing others; it is the only" ,
                        "thing." ,

                        "Excellence is an option that is renewable." ,

                        "Expectations should not determine whether or not one acts, nor how." ,

                        "Expensive fertilizers that do nothing for your grass will give you the" ,
                        "most gorgeous weeds you ever saw." ,

                        "Experience is a good teacher, but submits huge bills." ,

                        "Experience is what you get when you don't get what you wanted." ,

                        "Experimentation is the mother of confusion." ,

                        "Extinction is the ultimate fate of all species." ,

                        "Extreme boredom serves to cure boredom." ,

                        "Extreme sorrow laughs; extreme joy weeps." ,

                        "Extremely happy and extremely unhappy men are alike prone to grow" ,
                        "hard-hearted." ,

                        "Facts cannot prevail against faith, or adamant folly." ,

                        "Failure is a measurement that depends on the standard applied." ,

                        "Fear is no great respecter of reason." ,

                        "Feed the wolf as you will; he will always look to the forest." ,

                        "Fill what's empty." ,
                        "Empty what's full." ,
                        "And scratch where it itches." ,
                        "" ,
                        "Fire and water." ,
                        "Matter and anti-matter." ,
                        "Money and morality." ,

                        "First secure an independent income, then practice virtue." ,

                        "Fools belittle that which they do not understand." ,
                        "Cynics belittle everything." ,
                        "Midgets simply belittle." ,

                        "For a man of fortitude, there are no walls, only avenues." ,

                        "For peace of mind, resign as general manager of the universe." ,

                        "Freedom can be lost as surely tax by tax, regulation by regulation, as" ,
                        "it can be bullet by bullet, missile by missile." ,

                        "Freedom is for everyone. Or no one." ,

                        "Freedom of the press is limited to those who have one." ,

                        "Friends may come and friends may go, but enemies accumulate." ,

                        "Frustration is not having anyone else to blame but one's self." ,

                        "Get too many irons in your fire and you'll put it out." ,

                        "Give all orders verbally. Never write down anything that might go into" ,
                        "a \"Pearl Harbor file\"." ,

                        "Give me an example of pro and con." ,
                        "Progress and Congress." ,

                        "Given that Nature limited the intelligence of Man, it seems unfair" ,
                        "that she did not limit the stupidity of Man." ,

                        "God can't alter history, so he created historians." ,

                        "God has Alzheimer's disease; he's forgotten that we exist." ,

                        "God made everything out of nothing. But the nothingness shows" ,
                        "through." ,

                        "Government corruption seems always to be reported in the past tense." ,

                        "Half of conversation is listening." ,

                        "Have a nice day...somewhere else." ,

                        "He is all fault who has no fault at all." ,

                        "He who dies with the most toys, wins!" ,

                        "He who does many things makes many mistakes, but never makes the" ,
                        "biggest mistake of all - doing nothing." ,

                        "He who endures, wins." ,

                        "He who has been bitten by six dogs is legitimately suspicious of the" ,
                        "seventh." ,

                        "He who leaves nothing to chance will do very few things wrong, but he" ,
                        "will do very few things at all." ,

                        "He who lives on hope has a slender diet indeed." ,

                        "He who looks too far ahead stumbles over his own boots." ,

                        "He who would climb to the top must leave much behind." ,

                        "He who would leap high must take a long run." ,

                        "He who would pursue revenge should first dig two graves." ,

                        "Hell is l is a city much like Newark." ,

                        "Hell is not a place. Hell is what hurts worst." ,

                        "History is the sum total of things that could have been avoided." ,

                        "History occurs twice - the first time as tragedy, the second time as" ,
                        "farce." ,

                        "Honesty in politics is much like oxygen." ,
                        "The higher up you go, the scarcer it becomes." ,

                        "Honesty is the best policy - unless, of course, you are dealing with" ,
                        "your wife, your girlfriend, your banker, your employer, the I.R.S.," ,
                        "your creditors..." ,

                        "How can you tell when a salesman is lying ?" ,
                        "When his lips are moving." ,

                        "How come nowadays the word \"honesty\" is generally preceded by the" ,
                        "phrase \"old-fashioned\" ?" ,

                        "How long a minute is depends upon which side of the bathroom door" ,
                        "you're on." ,

                        "I get my exercise acting as a pallbearer for my friends who exercise." ,

                        "If a cluttered desk is characteristic of a cluttered mind, what does" ,
                        "an empty desk mean ?" ,

                        "If a problem causes too many meetings, then the meetings eventually" ,
                        "become more important than the problem." ,

                        "If all else fails, read the destructions." ,

                        "If all the economists in the world were laid end to end, they couldn't" ,
                        "reach a conclusion." ,

                        "If an experiment works, something has gone wrong." ,

                        "If builders constructed buildings the way programmers write programs," ,
                        "then the first woodpecker to come along would destroy civilization." ,

                        "If doctors' intellects were as big as doctors' egos, this would be a" ,
                        "far healthier world." ,

                        "If everything appears to be going well, you obviously don't know what" ,
                        "the hell is going on." ,

                        "If it jams - force it. If it breaks, it needed replacing anyway." ,

                        "If it's not in the computer, then it doesn't exist." ,

                        "If it's rational, if it's logical, and if it makes good common sense," ,
                        "then it's simply not done." ,

                        "If man's best friend is the dog, where does that leave the rest of us?" ,
                        "" ,

                        "If mathematically you end up with the wrong answer, try multiplying by" ,
                        "the page number." ,

                        "If more than one person is responsible for a miscalculation, no one" ,
                        "will be at fault." ,

                        "If one views his problem sufficiently closely, he will recognize" ,
                        "himself as part of the problem." ,

                        "If someone gives you so-called good advice, do the opposite; you may" ,
                        "be certain that that will be the right thing nine times out of ten." ,

                        "If the facts are against you, argue the law. If the law is against" ,
                        "you, pound the table and yell like hell." ,

                        "If the first person who answers the phone can't handle your question," ,
                        "then it's a bureaucracy." ,

                        "If the gods had really intended men to fly, they'd have made it easier" ,
                        "to get to the airport." ,

                        "If the government hasn't yet taxed, licensed, or regulated it, then it" ,
                        "probably ain't worth anything." ,

                        "If the nation's economists were all laid end to end, they would point" ,
                        "in all directions." ,
                        "" ,
                        "If the plating work that we do for you is defective, we will refund" ,
                        "your money, redo the parts free, close our plant, and have the plant" ,
                        "manager shot. Will that be satisfactory ?" ,

                        "If the shoe fits, you're not allowing for growth." ,

                        "If the thought of growing old bothers you, consider the alternative." ,

                        "If the universe is indeed insane, who is the asylum keeper ?" ,

                        "If this is the land of the future, why are we all so given to" ,
                        "nostalgia ?" ,

                        "If truth were a matter of opinion, then the majority would always be" ,
                        "right." ,

                        "If you are feeling good, don't worry; you'll get over it." ,

                        "If you can keep your head while all about you are losing theirs, then" ,
                        "you obviously don't understand what's going on." ,

                        "If you cannot convince them, confuse them." ,

                        "If you cannot logically refute a man's arguments, not all is lost. You" ,
                        "can always call him nasty names." ,

                        "If you cannot understand it, it is intuitively obvious." ,

                        "If you disinfect the pond, you kill the lilies." ,

                        "If you doubt that Rochesterians believe in God, watch how they drive." ,

                        "If you gave a monkey control of its environment, it would fill the" ,
                        "universe with bananas." ,
                        "" ,
                        "If you live among the wolves, learn to howl like them." ,

                        "If you think that mental illness interferes with financial success," ,
                        "just look at the average television evangelist." ,

                        "If you think that no one cares that you're alive, try missing a few" ,
                        "car payments." ,

                        "If you try to please everybody, nobody will like it." ,

                        "If you want to make people angry, lie to them. If you want to make" ,
                        "them absolutely livid, then tell 'em the truth." ,

                        "If young women often do marry men like their fathers, no wonder their" ,
                        "mothers cry at their weddings." ,

                        "In America, the Secretary of Agriculture catches hell for unmanageable" ,
                        "food surpluses; in Russia, his counterpart goes to Siberia because of" ,
                        "unmanageable food shortages." ,

                        "In a mad world, only greater madness succeeds." ,

                        "In a permissive society, the cream rises to the top...and so does the" ,
                        "scum." ,

                        "In a world that runs on deceit, deception, and duplicity, the honest" ,
                        "man is always at a disadvantage." ,

                        "In any organization, there are only two people to contact if you want" ,
                        "results:" ,
                        "   the one at the very top and the one at the very bottom." ,

                        "In case of doubt, make it sound convincing." ,

                        "In death, avoid hell." ,
                        "In life, avoid the law courts." ,

                        "In defeat, malice." ,
                        "In victory, revenge." ,

                        "In designing any type of machine component, no overall dimension can" ,
                        "be totalled accurately after 4:30pm Friday. The correct total will" ,
                        "become self-evident at 8:15am on Monday." ,

                        "In doing good, avoid notoriety. In doing evil, avoid self-awareness." ,

                        "In hell, treason is the work of angels." ,

                        "In jealousy, there is often more self-love than love." ,

                        "In order to obtain a loan, you must first prove that you don't need" ,
                        "it." ,

                        "In some countries, Chaucer and Dante are the classics. In this" ,
                        "country, it's a soft drink." ,

                        "In the Beginning, God created the Organization and gave It dominion" ,
                        "over man." ,
                        " -Genesis, Article VII, section 3, paragraph C." ,

                        "In the final analysis, entropy always wins." ,

                        "In the long run, we are all dead." ,
                        "" ,
                        "In third-world politics, the people with the guns call the shots." ,

                        "Injustice anywhere is a threat to justice everywhere." ,

                        "Inside every short man is a tall man doubled over in extreme pain." ,

                        "Instead of worrying about the boxes in your organizational chart, be" ,
                        "concerned with the people who are boxed in." ,

                        "Institutions are more rarely overthrown from without, more often" ,
                        "corroded from within." ,

                        "Interesting history is awful living." ,

                        "Isn't it strange that the same people who laugh at gypsy" ,
                        "fortune-tellers take economists seriously." ,

                        "It doesn't much matter whom you marry, for tomorrow morning you" ,
                        "discover that it was someone else." ,

                        "It is a grave error to allow any mechanical device to realize that you" ,
                        "are in a hurry." ,

                        "It is axiomatic that even the strongest of men will fall before a" ,
                        "pygmy with a submachine gun." ,

                        "It is better to add life to your years than it is to add years to your" ,
                        "life." ,

                        "It is better to be envied than to be consoled." ,

                        "It is better to resign from office than it is to die in office; that" ,
                        "way, you get to hear some of the eulogies." ,

                        "It is difficult to be politically conscious and upwardly mobile at the" ,
                        "same time." ,

                        "It is impossible to make anything foolproof because fools are so" ,
                        "ingenious." ,

                        "It is morally wrong to allow suckers to keep their money." ,

                        "It is often easier to find the truth than it is to accept it." ,

                        "It is only in Aesop's fables that an elephant takes advice from a" ,
                        "mouse." ,

                        "It is probably better to be insane with the rest of the world than to" ,
                        "be sane alone." ,

                        "It is the manner, and not the content, that marks a gentleman." ,

                        "It is when the irritation of doubt causes a struggle to attain belief" ,
                        "that the enterprise of thought begins." ,

                        "It is wrong to repeat gossip, but what else can you do with it ?" ,

                        "It takes twenty-five dumb animals to make a fur coat. and only one to" ,
                        "wear it." ,

                        "It takes very little to make a woman happy, and more than is contained" ,
                        "in heaven and earth to keep her that way." ,

                        "It's difficult to soar with the eagles when you work with turkeys." ,
                        "" ,
                        "It's not social oppression that moves wild-eyed revolutionaries; it's" ,
                        "envy, pure and simple." ,

                        "It's not whether you win or lose, it's how you place the blame." ,

                        "It's what you learn after you know it all that counts." ,

                        "John Donne was wrong." ,

                        "Journalism, like prostitution, is a career in which just one foray" ,
                        "makes a professional." ,

                        "Just because you are paranoid does not mean that no one is following" ,
                        "you." ,

                        "Justice must not only be done; it must be seen to be believed." ,

                        "Kill the moneylenders." ,

                        "Knowledge can cure ignorance, but intelligence cannot cure stupidity." ,

                        "Labor disgraces no man, but often a man disgraces labor." ,

                        "Large brains can contain small minds." ,

                        "Last weke I cudn't even spel kumpooter programer and today I are one!" ,

                        "Law remains long after justice flees." ,

                        "Leakproof seals - will." ,
                        "Selfstarters - will not." ,
                        "Interchangeable parts - won't." ,

                        "Leftover nuts never match leftover bolts." ,

                        "Less of a good thing is sometimes better - ask anyone on a diet." ,

                        "Life is a learning experience; the diploma is your death certificate." ,

                        "Life is a temporary assignment." ,

                        "Life is a terminal condition." ,

                        "Life's a bitch." ,
                        "But, then, consider the alternative." ,

                        "Little boys throw stones in jest." ,
                        "Little frogs die in earnest." ,

                        "Live every day as though it were your last." ,
                        "One day, you'll be right." ,

                        "Live within your income, even if you must borrow to do it." ,

                        "Locks and keys are for honest people." ,

                        "Logic is a systematic method of coming to the wrong conclusion with" ,
                        "confidence." ,

                        "Lost causes are the only ones worth fighting for." ,

                        "Luck, it is said, dislikes working double shifts." ,

                        "Making this world better will gain you the greatest credit in the next" ,
                        "one." ,

                        "Man does not live by bread alone." ,
                        "But he damned well doesn't live without it, either." ,

                        "Many know how to flatter; few know how to praise." ,

                        "Marriage is like burning the house down to toast the bread." ,

                        "Marriage is the only adventure open to the cowardly." ,

                        "May you live in interesting times." ,

                        "Mayflies continually plot to topple the cedar." ,

                        "Measure twice 'cause you can only cut once." ,

                        "Measured with a micrometer." ,
                        "Marked with chalk." ,
                        "Cut with an axe." ,

                        "Men and nations will act rationally when all other possibilities have" ,
                        "been exhausted." ,

                        "Men heap together the mistakes of their lives and create a monster" ,
                        "they call destiny." ,

                        "Middle age is when you wonder if your warranty is running out." ,

                        "Miles aren't the only distance." ,

                        "Monotony is the law of Nature. Observe the monotonous manner in which" ,
                        "the sun rises." ,

                        "More men are sheep in wolves' clothing than the other way around." ,

                        "Most men and nations die lying down." ,

                        "Mother Nature applies all her rules...all the time." ,

                        "Motor gently through the greasemud, for there lurks the skid demon." ,

                        "Murphy's Golden Rule:" ,
                        "   Whoever has the gold makes the rules." ,

                        "Murphy's Law: If it can go wrong, it will...at the worst possible time" ,
                        "and in the worst possible place." ,
                        "Fisher's Law: Murphy was an optimist." ,

                        "Nature always sides with the hidden flaw." ,

                        "Never argue with a fool...people may not be able to tell you apart." ,

                        "Never claim as a right that which you can ask as a favor." ,

                        "Never climb a fence when you can sit on it." ,

                        "Never complain;" ,
                        "never explain." ,

                        "Never do card tricks for the group you play poker with." ,

                        "Never eat prunes when you are famished." ,

                        "Never embezzle more than your employer can afford." ,
                        "" ,
                        "Never get into a fight with an ugly person. He has nothing to lose." ,

                        "Never get mixed up with economists. Their thinking is muddy and they" ,
                        "have bad breath." ,

                        "Never have so many people understood so little about so much." ,

                        "Never invest in anything that eats or needs repainting." ,

                        "Never let your sense of morality stop you from doing what is right." ,

                        "Never make the same mistake twice...there are so many new ones to" ,
                        "make!" ,

                        "Never marry a woman who prays too much." ,

                        "Never mistake good manners for good will." ,

                        "Never play leapfrog with a unicorn." ,

                        "Never question your wife's judgement...look whom she married." ,

                        "Never step in anything soft." ,

                        "Never trust anyone who laughs at his own one-liners." ,

                        "Never try to teach a pig how to sing. It is a waste of time and it" ,
                        "annoys the pig." ,

                        "Never underestimate the power of stupidity." ,

                        "Never, ever trust anyone under 30 or over 25." ,

                        "Never, ever, insult a telephone answering machine. They have ways of" ,
                        "getting even." ,

                        "New systems generate new problems." ,

                        "Next to being shot at and missed, nothing is really quite as" ,
                        "satisfying as an income tax refund." ,

                        "No class of Americans has ever objected to any amount of government" ,
                        "meddling if it appeared to benefit that particular class." ,

                        "No man's knowledge goes beyond his experience." ,

                        "No man's life, liberty, or property are safe whilst the legislature is" ,
                        "in session." ,

                        "No matter how bad your kid is, he's still good for a tax exemption." ,

                        "No matter how long or how diligently you shop for a machine, once" ,
                        "you've purchased it, it will be on sale for 30% less." ,

                        "No name, no matter how simple, can be correctly understood over the" ,
                        "phone." ,

                        "No one can make you feel inferior without your consent." ,

                        "No one ever found marvels by seeking them." ,

                        "No one gets too old to learn a new way of being stupid." ,

                        "Not all the kookies are in the jar." ,
                        "" ,
                        "Nothing dispels enthusiasm like a small admission fee." ,

                        "Nothing in our history is plainer, or more tragic, than the gulf" ,
                        "between cleverness and wisdom." ,

                        "Nothing in the universe arouses more false hopes than the first four" ,
                        "hours of a diet." ,

                        "Nothing irritates a standard American corporate executive quite so" ,
                        "much as the sight of someone actually daring to practice capitalism." ,

                        "Nothing is illegal if 100 businessmen decide to do it." ,

                        "Nothing is really labor unless you would rather be doing something" ,
                        "else." ,

                        "Nothing motivates a man more than to see his boss put in an honest" ,
                        "day's work." ,


                        "Odds are, the phrase \"It's none of my business\" will be followed by" ,
                        "\"but\"." ,

                        "Of those teaching in today's schools, 80 percent are paid twice what" ,
                        "they are worth and 20 percent are paid half what they are worth." ,

                        "Old age is like a burglar." ,
                        "It robs you of all the goodies and leaves the rubbish." ,

                        "Old men and comets have long been revered for the same reasons; their" ,
                        "long beards and their supposed ability to foretell events." ,

                        "Old men make wars." ,
                        "Young men fight them." ,

                        "On the ONE day you take your secretary to lunch, your wife will be" ,
                        "lunching in the same restaurant." ,

                        "Once upon a time, there were two Chinamen." ,
                        "Now look how many there are." ,

                        "Once you understand the problem, you find that it is worse than you" ,
                        "expected." ,

                        "One goddamned thing leads to another goddamned thing." ,

                        "One good thing about living on a farm is that you can fight with your" ,
                        "wife and ain't nobody gonna hear." ,

                        "One lawyer = a crook." ,
                        "Two lawyers = a law firm." ,
                        "Three or more lawyers = a legislature." ,

                        "One may generally observe a singular accord between supercelestial" ,
                        "ideas and subterranean behavior." ,

                        "One sees more clearly backward than forward." ,

                        "One thing you can say for kids: they don't go around showing pictures" ,
                        "of their grandparents." ,

                        "Opportunity always knocks at the least opportune moment." ,

                        "Our architect's plans for plant renovation begin with a precision air" ,
                        "strike." ,

                        "Peace is a premise the existence of which we have deduced from the" ,
                        "intervals between wars." ,

                        "People are always available for work in the past tense." ,

                        "People use the most words when they are the least certain of what they" ,
                        "are saying." ,

                        "People who cough a lot never go to the doctor...just to movies," ,
                        "concerts, and lectures." ,

                        "People who have no faults are terrible: there is no way to take" ,
                        "advantage of them." ,

                        "People who live in a golden age complain that everything looks" ,
                        "yellow." ,

                        "People, like turtles, make little progress without sticking their" ,
                        "necks out." ,

                        "Pessimists are the world's happiest people...." ,
                        "Ninety percent of the time they are right, and the other ten percent" ,
                        "they are pleasantly surprised." ,

                        "Pinocchio was such a dolt to try to become a human being. He was much" ,
                        "better off with a wooden head." ,

                        "Policemen with private motives are dangerous." ,

                        "Political cunning should never be mistaken for intelligence." ,

                        "Politicians are much like ships: noisiest when lost in a fog." ,

                        "Politicians deal with the public on the basis of the mushroom policy:" ,
                        "Keep them in the dark and feed them manure." ,

                        "Practical politics consists of ignoring the facts. Come to think of" ,
                        "it, practical anything consists of that." ,

                        "Proctologist's revenge: put Ben-Gay in a guy's tube of Nupercainal." ,

                        "Proof-positive that Eastern and Western technologies can indeed work" ,
                        "together: the Teflon-coated wok." ,

                        "Psychopaths aren't born. They are made." ,

                        "Rabbits dance at the funeral of the lion." ,

                        "Reality precedes perception." ,
                        "Except, of course, in southern California." ,

                        "Remember the good old days When juvenile delinquency was observed" ,
                        "mainly in juveniles" ,

                        "Remember when \"There's something in the air\" was just a figure of" ,
                        "speech" ,

                        "Respect for ourselves guides our morals; deference to others governs" ,
                        "our manners." ,

                        "Revenge is a dish best served cold." ,
                        "" ,
                        "Roughing it is television without cable." ,

                        "Rumors are the sauce of a dry life." ,

                        "Saints engage in introspection while burly sinners run the world." ,

                        "Scandal, like hypocrisy, is bipartisan." ,

                        "Science has finally found what distinguishes Man from the other" ,
                        "beasts: financial worries." ,

                        "Serendipity is looking in a haystack for a needle and finding the" ,
                        "farmer's daughter." ,

                        "Show me anything whereof it may be said \"See, this is new,\" and I will" ,
                        "show you it hath been." ,

                        "Shrink not from blasphemy - t'will pass for wit." ,

                        "Simple pleasures are the last refuge of the complex." ,

                        "Since few large pleasures are lent to us on a long lease, it is wise" ,
                        "to cultivate a large undergrowth of small pleasures." ,

                        "Small things entertain small minds." ,

                        "Smooth seas never made a good sailor." ,

                        "Some people are always lost in thought; other people lack thoughts" ,
                        "large enough to be lost in." ,

                        "Some people can look so busy that they seem indispensable." ,

                        "Some people can stay longer in an hour than others can in a week." ,

                        "Some people manage by the book, even though they don't know who wrote" ,
                        "the book or even what book." ,

                        "Sometimes it is good to be only a fly when giants are fighting for the" ,
                        "heavens." ,

                        "Sometimes, a cigar is just a cigar." ,
                        "    - S. Freud" ,

                        "Songs unheard are sweeter far." ,

                        "Stress is that condition created when the mind overrides the body's" ,
                        "basic desire to choke the living shit out of some asshole who" ,
                        "desperately needs it." ,

                        "Strong words connote weak arguments." ,

                        "Succeeding is more satisfying than success." ,

                        "Success consists of reaching 40 before your waist does." ,

                        "Support your local bloodhound." ,
                        "Get lost." ,

                        "Sympathy is what you give a relative when you don't want to lend him" ,
                        "cash." ,

                        "Take care which rut you choose; you'll be in it for the next ten" ,
                        "years." ,
                        "" ,
                        "Taking something with a grain of salt may raise your blood pressure." ,

                        "Tatoos are the common man's way of investing in art." ,

                        "Technology is dominated by those who manage what they do not" ,
                        "understand." ,

                        "Television is chewing gum for the eyes." ,

                        "Tell a man that there are 500 million trillion stars in the universe" ,
                        "and he will believe you. Tell him that there's wet paint on that" ,
                        "bench...." ,

                        "Tempt not a desperate man." ,

                        "That which is crooked cannot be made straight, although there are" ,
                        "psychotherapists who might disagree." ,

                        "The Boy Scout credo: sound mind, sound body...take your choice." ,

                        "The British parliament is called the \"Mother of Legislatures\". A" ,
                        "somewhat similar term is often applied to Congress." ,

                        "The Devil's greatest triumph was convincing the modern world that he" ,
                        "doesn't exist." ,

                        "The Russians will never invade us...there's no place to park." ,

                        "The attention span of a computer is only as long as its electrical" ,
                        "cord." ,

                        "The average U.S. taxpayer is proud to be paying taxes. Of course, he" ,
                        "could be just as proud for half the money." ,

                        "The best bilge pump in the world is a terrified sailor with a bucket." ,

                        "The best way to achieve immortality is by not dying." ,

                        "The best way to attract money is to give the appearance of having it." ,

                        "The best way to avoid growing old is not to be born so soon." ,

                        "The best way to make fire with two sticks is to insure that one of" ,
                        "them is a match." ,

                        "The best way to save face is to keep the lower half closed." ,

                        "The bigger they are, the harder they punch." ,

                        "The biggest idiot can ask questions the smartest man cannot answer." ,

                        "The danger in being king is that after a while you begin to believe" ,
                        "you really are one." ,

                        "The deepest and most important virtues are often the dullest ones." ,

                        "The degree of technical competence is inversely proportional to the" ,
                        "level of management." ,

                        "The fifteen minute morning coffee break is when your employees take a" ,
                        "break from doing nothing." ,

                        "The first great gift that we can bestow upon others is a good" ,
                        "example." ,

                        "The first place in which to look for something is the last place in" ,
                        "which you expect to find it." ,

                        "The fraudulence of the exercise is proportional to the margin of" ,
                        "victory." ,

                        "The galaxy is full of dishonorable men ...Well, everyone's got to make" ,
                        "a living." ,

                        "The gap between theory and practice is filled with apology." ,

                        "The great classes of people will more easily fall victims to a great" ,
                        "lie than to a small one." ,

                        "The great tragedy of our era is not the significance of things but the" ,
                        "insignificance of things." ,

                        "The healthy stomach is nothing if not conservative; few radicals have" ,
                        "good digestions." ,

                        "The human brain is a wonderous instrument. It starts working the" ,
                        "moment you wake up and doesn't stop until you get to the office." ,

                        "The last man on Earth sat alone in a room." ,
                        "There was a knock on the door..." ,

                        "The last time doctors went on strike, the death rate dropped thirty" ,
                        "percent." ,

                        "The later you are for your flight, the more times you have to go" ,
                        "through the metal detector." ,

                        "The law, in its majestic equality, forbids the rich as well as the" ,
                        "poor to sleep under bridges, beg in the streets, and steal bread." ,

                        "The lawyer's credo: if you can't dazzle 'em with brilliance, baffle" ,
                        "'em with bullshit." ,

                        "The light at the end of the tunnel is the headlamp of an oncoming" ,
                        "train." ,

                        "The longer you wait in line, the greater the probability that it is" ,
                        "the wrong line." ,

                        "The man who is always talking about being a gentleman never is one." ,

                        "The more cordial the buyer's secretary, the greater the probability" ,
                        "that the competition already has the order." ,

                        "The most beautiful days of the year are always the days just before" ,
                        "and just after your vacation." ,

                        "The most successful journey is a dull journey." ,

                        "The mouse dreams dreams that would terrify the cat." ,

                        "The nice thing about scientific studies is that you can always find" ,
                        "one that proves conclusively that your product is safe and that your" ,
                        "competitor's causes cancer." ,

                        "The number of employees in any work group tends to increase" ,
                        "irrespective of the amount of work to be done." ,

                        "The number of people watching you is directly proportional to the" ,
                        "stupidity of what you're doing." ,
                        "" ,
                        "The one time in the day that you lean back and relax is the one time" ,
                        "the boss comes strolling through the plant." ,

                        "The only government handout that I want is the government's hand out" ,
                        "of my pocket." ,

                        "The only imperfect thing in nature is the human race." ,

                        "The only people that snobs want to know are those who don't want to" ,
                        "know them." ,

                        "The only people to profit from the mistakes of others are" ,
                        "biographers." ,

                        "The only perfect science is hindsight." ,

                        "The only thing worse than a male chauvinist pig is the female" ,
                        "version." ,

                        "The only things in history that are inevitable are those that have" ,
                        "already happened." ,

                        "The only valid generalization that can be made about scientists is" ,
                        "that they require unlimited resources for improbable projects of" ,
                        "interminable gestation periods." ,

                        "The opera ain't over 'til the fat lady sings." ,

                        "The opulence of the front office decor varies inversely with the" ,
                        "fundamental solvency of the firm." ,

                        "The organization of any bureaucracy is very much like a septic" ,
                        "tank....The really big chunks always rise to the top." ,

                        "The person who buys the most raffle tickets has the least chance of" ,
                        "winning." ,

                        "The person who marries for money generally ends up earning it." ,

                        "The person who snores the loudest will fall asleep first." ,

                        "The price of total freedom is total anarchy. The price of total" ,
                        "security is total enslavement." ,

                        "The primary function of the design engineer is to make things" ,
                        "difficult for the fabricator and impossible for the serviceman." ,

                        "The probability of a piece of bread falling with the buttered side" ,
                        "down is proportional to the cost of the carpet." ,

                        "The probability of your alarm not going off increases in direct" ,
                        "proportion to the importance of your 8:00am meeting." ,

                        "The promises of maniacs, like those of salesmen, are not safely relied" ,
                        "upon." ,

                        "The race is not always to the swift, nor the battle to the strong, but" ,
                        "that's the way to bet 'em." ,

                        "The rat race is over. The rats won." ,

                        "The real crime in education today is not the way we treat teachers but" ,
                        "whom we allow to be teachers." ,

                        "The real outrage today isn't what's illegal." ,
                        "It's what is legal." ,

                        "The reason the way of the sinner is hard is because it is so crowded." ,

                        "The reason why worry kills more people than work does is that more" ,
                        "people worry than work." ,

                        "The repairman will never have seen a model quite like yours before." ,

                        "The saddest of words: I always wanted to but never did." ,

                        "The secret of staying young is finding an age that you really like and" ,
                        "then sticking with it." ,

                        "The secret of success is sincerity. Once you can fake that, you've got" ,
                        "it made." ,

                        "The ship of state is the only ship that leaks at the top." ,

                        "The smaller the issue, the bigger the fight." ,

                        "The sole reliable test of a first-rate intelligence is to hold two" ,
                        "opposite ideas in the mind whilst still retaining the ability to tie" ,
                        "one's own shoe" ,
                        "laces." ,

                        "The sooner man begins to spend his wealth, the better he uses it." ,

                        "The strongest part of any paper form is the perforation." ,

                        "The successful enjoyment of vice requires training and long practice." ,

                        "The sun ariseth and the sun goeth down, and the same things come alike" ,
                        "to the righteous and the wicked." ,

                        "The supreme irony of life is that hardly anyone gets out of it alive." ,

                        "The tale of the errant entrepreneur:" ,
                        "High chair; high school; high hopes; high finance; \"Hi, Warden!\"." ,

                        "The universe is governed by a committee; no one man could make that" ,
                        "many mistakes." ,

                        "The very same American textile industry that lobbies hysterically" ,
                        "against the import of textile products imports virtually all its" ,
                        "textile manufacturing machinery...I wonder why" ,

                        "The whole of life is futile unless you regard it is a sporting" ,
                        "proposition." ,

                        "The world is a comedy to those that think, a tragedy to those that" ,
                        "feel." ,

                        "The world is disgracefully managed; one hardly knows to whom to" ,
                        "complain." ,

                        "Them that has, gets." ,

                        "There are no moral messages in Nature." ,
                        "There are only four basic plots in life, and nine in literature." ,
                        "There are those who make things happen." ,
                        "There are those who watch things happen." ,
                        "And there are those who wonder what happened." ,
                        "There are three rules for successfully managing people:" ,
                        "Unfortunately, no one knows what they are." ,
                        "There are three types of deliberate falsehoods: lies, damned lies, and" ,
                        "salesmen's promises." ,
                        "There are two kinds of men who never amount to much: those who cannot" ,
                        "do what they are told, and those who can do nothing else." ,
                        "There are two periods in which Congress does no business: one is" ,
                        "before the holidays and the other is after." ,
                        "There is a time for everything." ,
                        "Mostly, the wrong time." ,
                        "There is always one more son of a bitch than you counted on." ,
                        "There is an optimal size for any project, and it is always bigger than" ,
                        "you can afford." ,
                        "There is no truth in the rumor that man is immortal." ,
                        "There is nothing like a grievance to sharpen an old man's wits." ,
                        "There is nothing more terrible than ignorance in action." ,
                        "There is nothing wrong with you that an expensive surgical operation" ,
                        "cannot prolong." ,
                        "There is wisdom in madness and strong probability of truth in all" ,
                        "accusations, for people are complete, and everybody is capable of" ,
                        "anything." ,
                        "Ther's nothing wrong with gluttony...providing you don't overdo it." ,
                        "These days, an education is essential for career success. Unless, of" ,
                        "course, you run for Congress." ,
                        "They don't invite you to the White House for a drink because they" ,
                        "think you are thirsty." ,
                        "Tings get worse under pressure." ,
                        "Those things are better which are perfected by Nature than those which" ,
                        "are finished by art." ,
                        "Those who beat their swords into plowshares generally end up plowing" ,
                        "for those who didn't." ,
                        "Those who can - do." ,
                        "Those who can't - teach." ,
                        "Those totally devoid of useful ability become government economists." ,
                        "Those who can't teach - administer." ,
                        "Those who can't administer - run for public office." ,
                        "Those wh do not follow are dragged." ,
                        "Those who do not learn from history often end up making it." ,
                        "Those who like sausage or political policy should not watch either" ,
                        "being made." ,
                        "Time is a great teacher, but it kills all its pupils." ,
                        "To a little fish, the waters are always deep." ,
                        "To a man with a hammer, everything looks like a nail." ,
                        "To a weary horse, even his own tail is a burden." ,
                        "To err is human. To really foul things up requires a computer. To" ,
                        "create utter chaos with no perceivable possibility of salvation calls" ,
                        "for an MBA." ,
                        "To have honesty coupled to beauty is to have honey the sauce to" ,
                        "sugar." ,
                        "To hear tell a hundred times is not as good as once seeing." ,
                        "To spot te true expert, pick the one who predicts the job will take" ,
                        "the longest and cost the most." ,
                        "To understand the clay is not to understand the pot." ,
                        "Today's conservative is yesterday's liberal who got mugged last" ,
                        "night." ,
                        "Too much of anything is wonderful." ,
                        "Truth is a hard master to serve, for the more devotedly you serve her," ,
                        "the more she hurts you." ,
                        "Truth is very precious, so salesmen and politicians use it very" ,
                        "Tyranny is always better organized than freedom is." ,
                        "Under some conditions, in some place, at some time, there will always be at least one law, ordinance, or statute under which you can be booked." ,
                        "Under the most rigorously controlled conditions of temperatur, pressure, humidity, time, and voltage, the machine will do as it damned well pleases." ,
                        "Unfaithfulness in the keeping of an appointment is an act of clear dishonesty." ,
                        "You may as well take a person's money as his time." ,
                        "Universities are full of knowledge. The freshmen bring a little in and the seniors take none away, so knowledge accumulates." ,
                        "Virtue does not lend itself to the same verbal enthusiasms that vice does." ,
                        "Virtue is a social liability." ,
                        "We ain't cheap, but by gosh, we're good!" ,
                        "We are all passengers in the leaky rowboat of life. So, bail faster, damn it!" ,
                        "We are inclined to believe those whom we do not know because they have never deceived us." ,
                        "We do not know who first discovered water. However, we are confident that it was not a fish." ,
                        "We don't know one millionth of one per cent about anything." ,
                        "We know what we are, but not what we may be." ,
                        "Welcome to the totally-automated, fully computerized world of the twenty-first century, where nothing can go wrong...go wrong...go wrong..." ,
                        "What do the lie detector and Wonder Woman have in common They were invented by the same person. Kinda figures, doesn't it." ,
                        "What do you call 500 bureaucrats at the bottom of the Potomac river ? A start." ,
                        "What people say behind your back is your standing in the community." ,
                        "What the large print giveth, the small print taketh away." ,
                        "Whatever is not nailed down is the government's. Whatever the government can pry loose is not nailed down." ,
                        "When I works, I works fast." ,
                        "When I plays, I plays hard." ,
                        "And when I thinks, I falls asleep." ,
                        "When a broken machine is demonstrated for the repairman, it will work perfectly." ,
                        "When a man dies, he does not die just of the disease he has; he dies of his whole life." ,
                        "When anything is used to its full potential, it will break." ,
                        "When comes the revolution, things will be different - not better, just different." ,
                        "When in doubt, mumble." ,
                        "When in trouble, delegate." ,
                        "When in trouble or in doubt, Run in circles, yell and shout." ,
                        "When men are easy in their circumstances, they are naturally enemies to innovation." ,
                        "When smashing monuments, always save the pedestals - they come in handy." ,
                        "When the hounds bay, the fox and the rabbit are brothers." ,
                        "When the mouse laughs at the cat, there is a hole very near by." ,
                        "When the old dog barks, better look out the window." ,
                        "When there is no danger in fighting, there is no glory in winning." ,
                        "When you do not know what you are doing, do it neatly." ,
                        "When you've read about one train wreck, you've read about them all." ,
                        "Whenever a man casts a longing eye at public office, a rottenness appears in his conduct." ,
                        "Whenever a system becomes completely defined, some damned fool" ,
                        "discovers something which either abolishes the system or expands it totally beyond recognition." ,
                        "Where you stand on an issue depends upon where you sit." ,
                        "Who mourns the falling of a single leaf ?" ,
                        "Whom the gods would destroy, they first make mad." ,
                        "Why do they always start off the evening news with \"Good evening\" when all they do is tell you why it isn't ?" ,
                        "Why is there always so much month left at the end of the money ?" ,
                        "Why long for glory, which one despises as soon as one has it ?" ,
                        "Women like silent men. They think they're listening." ,
                        "Women's taste in neckties is as bad as men's in chintz." ,
                        "Work smarder and not harder and be careful of yor speling." ,
                        "Workers these days don't mind putting in an honest day's work. Trouble" ,
                        "is, it takes 'em a week to do it." ,
                        "Would that reason were as contagious as emotion." ,
                        "Would you fly in an airliner designed and built by the lowest bidder?" ,
                        "Yea, though I walk thru the valley of the shadow of death, I shall" ,
                        "fear no evil, 'cause I'm the meanest s.o.b. in the valley." ,
                        "Years ago, the symbol of America was the bald eagle. Today, it is the beer bottle on the side of the road." ,
                        "You can get more with a kind word and a gun than you can with a kind word." ,
                        "You can never tell which way the train went by looking at the track." ,
                        "You can say this for death and taxes: when you are done with one, you're done with the other." ,
                        "You can't drown your troubles, not the real ones, because if they are real, they can swim." ,
                        "You can't have a clear head when there is a sword hanging over it." ,
                        "You can't win." ,
                        "You cannot do a kindness too soon, for you never know when it will be too late." ,
                        "You cannot reason a man out of that which he has not been reasoned into." ,
                        "You cannot tame a tiger by pulling but one of his teeth." ,
                        "You know that it's gonna be a bad day when you call Suicide Prevention" ,
                        "and they put you on hold." ,
                        "You know you are in trouble when you come to work in the morning and" ,
                        "the boss tells you not to take off your coat." ,
                        "You know you are in trouble when your only son tells you he wishes" ,
                        "Anita Bryant would mind her own business." ,
                        "You may not get what you pay for, but you always pay for what you get." ,
                        "You never know how many friends you have until you own a house at the beach." ,
                        "You only go around once, and there's not enough gusto for everyone." ,
                        "You rarely observe a mob rushing across town to do a good deed." ,
                        "You've one mouth and two ears...use them in that proportion." ,
                        "Your freedom to swing your arm ends where my nose begins.");
                String random = randomsg.get(new Random().nextInt(randomsg.size()));
                int randomnum = new Random().nextInt(randomsg.size());
                if(randomnum*7 < cooldown){
                        ((EntityPlayer) entity).addChatMessage(new ChatComponentText("Fish"+randomnum+ " : " + random));
                        cooldown = 0;
                    }else{
                        cooldown++;
                    }
                    if(randomnum == 14){
                        int ran = new Random().nextInt();
                        ((EntityPlayer) entity).inventory.addItemStackToInventory(new ItemStack(Items.fish));
                        ((EntityPlayer) entity).addChatMessage(new ChatComponentText("Fish"+ran/2 + " : Hey where did fish" + ran + " go?"));
                    }
            }
        }
    }
}